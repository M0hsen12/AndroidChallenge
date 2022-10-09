package com.androidChallenge.view.fragments.home

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
import com.androidChallenge.view.adapter.ImagesAdapter
import com.androidChallenge.view.base.BaseFragment
import com.androidChallenge.view.fragments.details.FragmentDetails.Companion.ONCLICK_KEY_BUNDLE
import com.androidChallenge.viewModel.fragments.home.FragmentHomeViewModel
import com.androidChallenge.viewModel.fragments.home.FragmentHomeViewModel.Companion.FIRST_PAGE
import javax.inject.Inject

@BindModule
class FragmentHome : BaseFragment<FragmentHomeBinding, FragmentHomeViewModel>() {


    @Inject
    lateinit var mViewModelFactoryActivity: InjectionViewModelProvider<FragmentHomeViewModel>
    override fun getLayoutId() = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observeData()

    }

    private fun observeData() {

        viewModel?.apply {
            imagesLiveData.observe(viewLifecycleOwner) {
                setupRecyclerView(it)
            }
            errorLiveData.observe(viewLifecycleOwner) {
                Log.e("TAG", "observeData: $it")
            }
        }
    }

    private fun setupRecyclerView(image: Image) {

        binding.homeRv.apply {
            val myAdapter = ImagesAdapter(onItemClick = {
                navigateUserToDetailPage(it)
            })

            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = myAdapter

            myAdapter.submitList(image.hits.orEmpty())
        }
    }

    private fun navigateUserToDetailPage(it: HitsItem) {

        val bundle = Bundle()
        bundle.putInt(ONCLICK_KEY_BUNDLE,it.id)
        findNavController().navigate(R.id.action_fragmentHome_to_fragmentDetails,bundle)
    }

    private fun initUI() {
        viewModel = mViewModelFactoryActivity.get(this, FragmentHomeViewModel::class)
        viewModel?.getImages()
        viewModel?.nextPageImage(FIRST_PAGE)


    }


    companion object {
        fun newInstance() = FragmentHome()
    }
}