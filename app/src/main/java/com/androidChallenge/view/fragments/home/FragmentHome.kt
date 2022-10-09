package com.androidChallenge.view.fragments.home

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.androidChallenge.R
import com.androidChallenge.databinding.FragmentHomeBinding
import com.androidChallenge.di.modules.BindModule
import com.androidChallenge.di.viewModelInjection.InjectionViewModelProvider
import com.androidChallenge.models.images.HitsItem
import com.androidChallenge.models.images.Image
import com.androidChallenge.util.EndlessRecyclerOnScrollListener
import com.androidChallenge.util.materialSimpleProgressDialog
import com.androidChallenge.view.adapter.ImagesAdapter
import com.androidChallenge.view.base.BaseFragment
import com.androidChallenge.view.fragments.details.FragmentDetails.Companion.ONCLICK_KEY_BUNDLE
import com.androidChallenge.viewModel.fragments.home.FragmentHomeViewModel
import com.androidChallenge.viewModel.fragments.home.FragmentHomeViewModel.Companion.FIRST_PAGE
import java.util.ArrayList
import javax.inject.Inject

@BindModule
class FragmentHome : BaseFragment<FragmentHomeBinding, FragmentHomeViewModel>() {


    override fun getLayoutId() = R.layout.fragment_home

    @Inject
    lateinit var mViewModelFactoryActivity: InjectionViewModelProvider<FragmentHomeViewModel>
    private var endlessHandlerMyList: EndlessRecyclerOnScrollListener? = null
    private var imageList = ArrayList<HitsItem>()
    private lateinit var progressDialog: Dialog
    private lateinit var myAdapter: ImagesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observeData()

    }

    private fun observeData() {

        viewModel?.apply {
            imagesLiveData.observe(viewLifecycleOwner) {
                updateRecyclerView(it)
            }
            errorLiveData.observe(viewLifecycleOwner) {
                Log.e("TAG", "observeData: $it")
            }
        }
    }

    private fun updateRecyclerView(image: Image) {
        progressDialog.dismiss()
        val start = imageList.size
        imageList.addAll(image.hits.orEmpty())
        myAdapter.submitList(imageList)
        myAdapter.notifyItemRangeInserted(start,imageList.size)
        endlessHandlerMyList?.totalPages = image.total.toLong()

    }

    private fun navigateUserToDetailPage(it: HitsItem) {

        val bundle = Bundle()
        bundle.putParcelable(ONCLICK_KEY_BUNDLE, it)
        findNavController().navigate(R.id.action_fragmentHome_to_fragmentDetails, bundle)
    }

    private fun initUI() {
        viewModel = mViewModelFactoryActivity.get(this, FragmentHomeViewModel::class)
        progressDialog = materialSimpleProgressDialog(this.requireContext())
        progressDialog.show()
        viewModel?.getImages()
        viewModel?.nextPageImage(FIRST_PAGE)
        initRecyclerView()


    }

    private fun initRecyclerView() {
        binding.homeRv.apply {
            myAdapter = ImagesAdapter(onItemClick = {
                navigateUserToDetailPage(it)
            })
            endlessHandlerMyList =
                object : EndlessRecyclerOnScrollListener() {
                    override fun onLoadMore(currentPage: Int) {
                        progressDialog.show()
                        viewModel?.nextPageImage(currentPage)
                    }
                }

            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = myAdapter
            addOnScrollListener(endlessHandlerMyList!!)
        }
    }


    companion object {
        fun newInstance() = FragmentHome()
    }
}