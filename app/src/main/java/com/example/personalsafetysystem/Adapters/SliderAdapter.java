package com.example.personalsafetysystem.Adapters;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalsafetysystem.Model.SlideModel;
import com.example.personalsafetysystem.OnBoarding;
import com.example.personalsafetysystem.R;
import com.example.personalsafetysystem.UserDashboard.UserDashboard;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.OnboardingViewHolder> {

    private List<SlideModel> slideModelList;

    public SliderAdapter(List<SlideModel> slideModelList) {
        this.slideModelList = slideModelList;
    }

    @NonNull
    @Override
    public OnboardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item, parent, false);
        return new OnboardingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnboardingViewHolder holder, int position) {
        holder.setImage(slideModelList.get(position).getImage());
        holder.setIcon(slideModelList.get(position).getIcon());
        holder.setTitle(slideModelList.get(position).getHeading());
        holder.setDescription(slideModelList.get(position).getDescription());
    }


    @Override
    public int getItemCount() {
        return slideModelList.size();
    }

    class OnboardingViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        private ImageView iconView;

        private TextView titleTextView;
        private TextView descriptionTextView;

        private Button skipButton;

        public OnboardingViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.slider_image);
            iconView = itemView.findViewById(R.id.slider_icon);

            titleTextView = itemView.findViewById(R.id.slider_heading);
            descriptionTextView = itemView.findViewById(R.id.slider_desc);

            skipButton = itemView.findViewById(R.id.slider_skip);
            skipButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // skip onboarding and go to main activity
                    Intent intent = new Intent(v.getContext(), UserDashboard.class);
                    v.getContext().startActivity(intent);
                    ((OnBoarding)v.getContext()).finish();
                }
            });

        }

        void setImage(int image) {
            imageView.setImageResource(image);
        }

        void setIcon(int icon) {iconView.setImageResource(icon);
        }


        void setTitle(String title) {
            titleTextView.setText(title);
        }

        void setDescription(String description) {
            descriptionTextView.setText(description);
        }
    }
}
