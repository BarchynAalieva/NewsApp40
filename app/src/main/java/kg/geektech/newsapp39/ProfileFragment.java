package kg.geektech.newsapp39;

import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import kg.geektech.newsapp39.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    private ActivityResultLauncher<String> mGetContent;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initImg();
        photoFromGallery();

    }

    private void initImg() {
        mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),uri ->
                binding.imageView.setImageURI(uri));
    }

    private void photoFromGallery() {
        binding.imageView.setOnClickListener( v ->
        mGetContent.launch("image/*"));
    }
}