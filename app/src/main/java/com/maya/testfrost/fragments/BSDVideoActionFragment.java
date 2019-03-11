package com.maya.testfrost.fragments;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.chip.Chip;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maya.testfrost.R;
import com.maya.testfrost.constants.PlayBackSpeed;
import com.maya.testfrost.interfaces.fragments.IFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BSDVideoActionFragment extends BottomSheetDialogFragment implements IFragment {


    @BindView(R.id.chipSp1)
    Chip chipSp1;

    @BindView(R.id.chipSp2)
    Chip chipSp2;

    @BindView(R.id.chipSp3)
    Chip chipSp3;

    @BindView(R.id.chipSp4)
    Chip chipSp4;

    @BindView(R.id.chipSp5)
    Chip chipSp5;

    @BindView(R.id.chipSp6)
    Chip chipSp6;

    @BindView(R.id.chipSp7)
    Chip chipSp7;

    @BindView(R.id.chipSp8)
    Chip chipSp8;

    private PlayBackSpeed playBackSpeed;
    private ISpeedController iSpeedController;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playBackSpeed = PlayBackSpeed.values()[getArguments().getInt("PlayBackSpeed")];
    }

    public static BSDVideoActionFragment newInstance(PlayBackSpeed playBackSpeed, ISpeedController iSpeedController) {
        BSDVideoActionFragment fragment = new BSDVideoActionFragment();
        fragment.iSpeedController = iSpeedController;
        Bundle args = new Bundle();
        args.putInt("PlayBackSpeed", playBackSpeed.ordinal());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bsd_video_actions_fragment, container, false);
        ButterKnife.bind(this, view);

        setUp();

        // get the views and attach the listener

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void setUp() {


        switch (playBackSpeed) {
            case SPp25X:
                chipSp1.setChipIconResource(R.drawable.ic_check_circle);
                chipSp1.setTextColor(ContextCompat.getColor(activity(), R.color.colorPrimary));
                chipSp2.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp3.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp4.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp5.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp6.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp7.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp8.setTextColor(ContextCompat.getColor(activity(), R.color.black));

                chipSp1.setChipBackgroundColor(generateColorStateList(R.color.light_color_primary));
                chipSp2.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp3.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp4.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp5.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp6.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp7.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp8.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));


                chipSp1.setChipIconVisible(true);
                chipSp2.setChipIconVisible(false);
                chipSp3.setChipIconVisible(false);
                chipSp4.setChipIconVisible(false);
                chipSp5.setChipIconVisible(false);
                chipSp6.setChipIconVisible(false);
                chipSp7.setChipIconVisible(false);
                chipSp8.setChipIconVisible(false);
                break;

            case SPp5X:
                chipSp2.setChipIconResource(R.drawable.ic_check_circle);
                chipSp2.setTextColor(ContextCompat.getColor(activity(), R.color.colorPrimary));
                chipSp1.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp3.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp4.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp5.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp6.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp7.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp8.setTextColor(ContextCompat.getColor(activity(), R.color.black));


                chipSp1.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp2.setChipBackgroundColor(generateColorStateList(R.color.light_color_primary));
                chipSp3.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp4.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp5.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp6.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp7.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp8.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));


                chipSp1.setChipIconVisible(false);
                chipSp2.setChipIconVisible(true);
                chipSp3.setChipIconVisible(false);
                chipSp4.setChipIconVisible(false);
                chipSp5.setChipIconVisible(false);
                chipSp6.setChipIconVisible(false);
                chipSp7.setChipIconVisible(false);
                chipSp8.setChipIconVisible(false);

                break;

            case SPp75X:
                chipSp3.setChipIconResource(R.drawable.ic_check_circle);
                chipSp3.setTextColor(ContextCompat.getColor(activity(), R.color.colorPrimary));
                chipSp2.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp1.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp4.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp5.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp6.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp7.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp8.setTextColor(ContextCompat.getColor(activity(), R.color.black));


                chipSp1.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp2.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp3.setChipBackgroundColor(generateColorStateList(R.color.light_color_primary));
                chipSp4.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp5.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp6.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp7.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp8.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));

                chipSp1.setChipIconVisible(false);
                chipSp2.setChipIconVisible(false);
                chipSp3.setChipIconVisible(true);
                chipSp4.setChipIconVisible(false);
                chipSp5.setChipIconVisible(false);
                chipSp6.setChipIconVisible(false);
                chipSp7.setChipIconVisible(false);
                chipSp8.setChipIconVisible(false);
                break;

            case SP1X:
                chipSp4.setChipIconResource(R.drawable.ic_check_circle);
                chipSp4.setTextColor(ContextCompat.getColor(activity(), R.color.colorPrimary));
                chipSp2.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp3.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp1.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp5.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp6.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp7.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp8.setTextColor(ContextCompat.getColor(activity(), R.color.black));

                chipSp1.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp2.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp3.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp4.setChipBackgroundColor(generateColorStateList(R.color.light_color_primary));
                chipSp5.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp6.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp7.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp8.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));


                chipSp1.setChipIconVisible(false);
                chipSp2.setChipIconVisible(false);
                chipSp3.setChipIconVisible(false);
                chipSp4.setChipIconVisible(true);
                chipSp5.setChipIconVisible(false);
                chipSp6.setChipIconVisible(false);
                chipSp7.setChipIconVisible(false);
                chipSp8.setChipIconVisible(false);
                break;

            case SP1p25X:
                chipSp5.setChipIconResource(R.drawable.ic_check_circle);
                chipSp5.setTextColor(ContextCompat.getColor(activity(), R.color.colorPrimary));
                chipSp2.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp3.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp4.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp1.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp6.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp7.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp8.setTextColor(ContextCompat.getColor(activity(), R.color.black));

                chipSp1.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp2.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp3.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp4.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp5.setChipBackgroundColor(generateColorStateList(R.color.light_color_primary));
                chipSp6.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp7.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp8.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));

                chipSp1.setChipIconVisible(false);
                chipSp2.setChipIconVisible(false);
                chipSp3.setChipIconVisible(false);
                chipSp4.setChipIconVisible(false);
                chipSp5.setChipIconVisible(true);
                chipSp6.setChipIconVisible(false);
                chipSp7.setChipIconVisible(false);
                chipSp8.setChipIconVisible(false);

                break;

            case SP1p5X:
                chipSp6.setChipIconResource(R.drawable.ic_check_circle);
                chipSp6.setTextColor(ContextCompat.getColor(activity(), R.color.colorPrimary));
                chipSp2.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp3.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp4.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp5.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp1.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp7.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp8.setTextColor(ContextCompat.getColor(activity(), R.color.black));

                chipSp1.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp2.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp3.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp4.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp5.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp6.setChipBackgroundColor(generateColorStateList(R.color.light_color_primary));
                chipSp7.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp8.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));

                chipSp1.setChipIconVisible(false);
                chipSp2.setChipIconVisible(false);
                chipSp3.setChipIconVisible(false);
                chipSp4.setChipIconVisible(false);
                chipSp5.setChipIconVisible(false);
                chipSp6.setChipIconVisible(true);
                chipSp7.setChipIconVisible(false);
                chipSp8.setChipIconVisible(false);
                break;

            case SP1p75X:
                chipSp7.setChipIconResource(R.drawable.ic_check_circle);
                chipSp6.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp2.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp3.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp4.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp5.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp1.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp7.setTextColor(ContextCompat.getColor(activity(), R.color.colorPrimary));
                chipSp8.setTextColor(ContextCompat.getColor(activity(), R.color.black));

                chipSp1.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp2.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp3.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp4.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp5.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp6.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp7.setChipBackgroundColor(generateColorStateList(R.color.light_color_primary));
                chipSp8.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));

                chipSp1.setChipIconVisible(false);
                chipSp2.setChipIconVisible(false);
                chipSp3.setChipIconVisible(false);
                chipSp4.setChipIconVisible(false);
                chipSp5.setChipIconVisible(false);
                chipSp6.setChipIconVisible(false);
                chipSp7.setChipIconVisible(true);
                chipSp8.setChipIconVisible(false);
                break;

            case SP2X:
                chipSp8.setChipIconResource(R.drawable.ic_check_circle);
                chipSp6.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp2.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp3.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp4.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp5.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp1.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp7.setTextColor(ContextCompat.getColor(activity(), R.color.black));
                chipSp8.setTextColor(ContextCompat.getColor(activity(), R.color.colorPrimary));

                chipSp1.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp2.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp3.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp4.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp5.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp6.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp7.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
                chipSp8.setChipBackgroundColor(generateColorStateList(R.color.light_color_primary));

                chipSp1.setChipIconVisible(false);
                chipSp2.setChipIconVisible(false);
                chipSp3.setChipIconVisible(false);
                chipSp4.setChipIconVisible(false);
                chipSp5.setChipIconVisible(false);
                chipSp6.setChipIconVisible(false);
                chipSp7.setChipIconVisible(false);
                chipSp8.setChipIconVisible(true);

                break;

        }


        chipSp1.setOnClickListener(v -> {
            chipSp1.setChipIconResource(R.drawable.ic_check_circle);
            chipSp1.setTextColor(ContextCompat.getColor(activity(), R.color.colorPrimary));
            chipSp2.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp3.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp4.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp5.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp6.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp7.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp8.setTextColor(ContextCompat.getColor(activity(), R.color.black));

            chipSp1.setChipBackgroundColor(generateColorStateList(R.color.light_color_primary));
            chipSp2.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp3.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp4.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp5.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp6.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp7.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp8.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));


            chipSp1.setChipIconVisible(true);
            chipSp2.setChipIconVisible(false);
            chipSp3.setChipIconVisible(false);
            chipSp4.setChipIconVisible(false);
            chipSp5.setChipIconVisible(false);
            chipSp6.setChipIconVisible(false);
            chipSp7.setChipIconVisible(false);
            chipSp8.setChipIconVisible(false);

            iSpeedController.setPlaybackSpeed(PlayBackSpeed.SPp25X);
            this.dismiss();


        });

        chipSp2.setOnClickListener(v -> {
            chipSp2.setChipIconResource(R.drawable.ic_check_circle);
            chipSp2.setTextColor(ContextCompat.getColor(activity(), R.color.colorPrimary));
            chipSp1.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp3.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp4.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp5.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp6.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp7.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp8.setTextColor(ContextCompat.getColor(activity(), R.color.black));


            chipSp1.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp2.setChipBackgroundColor(generateColorStateList(R.color.light_color_primary));
            chipSp3.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp4.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp5.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp6.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp7.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp8.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));


            chipSp1.setChipIconVisible(false);
            chipSp2.setChipIconVisible(true);
            chipSp3.setChipIconVisible(false);
            chipSp4.setChipIconVisible(false);
            chipSp5.setChipIconVisible(false);
            chipSp6.setChipIconVisible(false);
            chipSp7.setChipIconVisible(false);
            chipSp8.setChipIconVisible(false);

            iSpeedController.setPlaybackSpeed(PlayBackSpeed.SPp5X);
            this.dismiss();


        });


        chipSp3.setOnClickListener(v -> {
            chipSp3.setChipIconResource(R.drawable.ic_check_circle);
            chipSp3.setTextColor(ContextCompat.getColor(activity(), R.color.colorPrimary));
            chipSp2.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp1.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp4.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp5.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp6.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp7.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp8.setTextColor(ContextCompat.getColor(activity(), R.color.black));


            chipSp1.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp2.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp3.setChipBackgroundColor(generateColorStateList(R.color.light_color_primary));
            chipSp4.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp5.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp6.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp7.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp8.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));

            chipSp1.setChipIconVisible(false);
            chipSp2.setChipIconVisible(false);
            chipSp3.setChipIconVisible(true);
            chipSp4.setChipIconVisible(false);
            chipSp5.setChipIconVisible(false);
            chipSp6.setChipIconVisible(false);
            chipSp7.setChipIconVisible(false);
            chipSp8.setChipIconVisible(false);

            iSpeedController.setPlaybackSpeed(PlayBackSpeed.SPp75X);
            this.dismiss();


        });

        chipSp4.setOnClickListener(v -> {


            chipSp4.setChipIconResource(R.drawable.ic_check_circle);
            chipSp4.setTextColor(ContextCompat.getColor(activity(), R.color.colorPrimary));
            chipSp2.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp3.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp1.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp5.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp6.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp7.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp8.setTextColor(ContextCompat.getColor(activity(), R.color.black));

            chipSp1.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp2.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp3.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp4.setChipBackgroundColor(generateColorStateList(R.color.light_color_primary));
            chipSp5.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp6.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp7.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp8.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));


            chipSp1.setChipIconVisible(false);
            chipSp2.setChipIconVisible(false);
            chipSp3.setChipIconVisible(false);
            chipSp4.setChipIconVisible(true);
            chipSp5.setChipIconVisible(false);
            chipSp6.setChipIconVisible(false);
            chipSp7.setChipIconVisible(false);
            chipSp8.setChipIconVisible(false);

            iSpeedController.setPlaybackSpeed(PlayBackSpeed.SP1X);
            this.dismiss();


        });

        chipSp5.setOnClickListener(v -> {
            chipSp5.setChipIconResource(R.drawable.ic_check_circle);
            chipSp5.setTextColor(ContextCompat.getColor(activity(), R.color.colorPrimary));
            chipSp2.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp3.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp4.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp1.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp6.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp7.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp8.setTextColor(ContextCompat.getColor(activity(), R.color.black));

            chipSp1.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp2.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp3.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp4.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp5.setChipBackgroundColor(generateColorStateList(R.color.light_color_primary));
            chipSp6.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp7.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp8.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));

            chipSp1.setChipIconVisible(false);
            chipSp2.setChipIconVisible(false);
            chipSp3.setChipIconVisible(false);
            chipSp4.setChipIconVisible(false);
            chipSp5.setChipIconVisible(true);
            chipSp6.setChipIconVisible(false);
            chipSp7.setChipIconVisible(false);
            chipSp8.setChipIconVisible(false);

            iSpeedController.setPlaybackSpeed(PlayBackSpeed.SP1p25X);
            this.dismiss();


        });

        chipSp6.setOnClickListener(v -> {
            chipSp6.setChipIconResource(R.drawable.ic_check_circle);
            chipSp6.setTextColor(ContextCompat.getColor(activity(), R.color.colorPrimary));
            chipSp2.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp3.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp4.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp5.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp1.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp7.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp8.setTextColor(ContextCompat.getColor(activity(), R.color.black));

            chipSp1.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp2.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp3.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp4.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp5.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp6.setChipBackgroundColor(generateColorStateList(R.color.light_color_primary));
            chipSp7.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp8.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));

            chipSp1.setChipIconVisible(false);
            chipSp2.setChipIconVisible(false);
            chipSp3.setChipIconVisible(false);
            chipSp4.setChipIconVisible(false);
            chipSp5.setChipIconVisible(false);
            chipSp6.setChipIconVisible(true);
            chipSp7.setChipIconVisible(false);
            chipSp8.setChipIconVisible(false);

            iSpeedController.setPlaybackSpeed(PlayBackSpeed.SP1p5X);
            this.dismiss();

        });


        chipSp7.setOnClickListener(v -> {
            chipSp7.setChipIconResource(R.drawable.ic_check_circle);
            chipSp6.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp2.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp3.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp4.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp5.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp1.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp7.setTextColor(ContextCompat.getColor(activity(), R.color.colorPrimary));
            chipSp8.setTextColor(ContextCompat.getColor(activity(), R.color.black));

            chipSp1.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp2.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp3.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp4.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp5.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp6.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp7.setChipBackgroundColor(generateColorStateList(R.color.light_color_primary));
            chipSp8.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));

            chipSp1.setChipIconVisible(false);
            chipSp2.setChipIconVisible(false);
            chipSp3.setChipIconVisible(false);
            chipSp4.setChipIconVisible(false);
            chipSp5.setChipIconVisible(false);
            chipSp6.setChipIconVisible(false);
            chipSp7.setChipIconVisible(true);
            chipSp8.setChipIconVisible(false);

            iSpeedController.setPlaybackSpeed(PlayBackSpeed.SP1p75X);
            this.dismiss();


        });


        chipSp8.setOnClickListener(v -> {
            chipSp8.setChipIconResource(R.drawable.ic_check_circle);
            chipSp6.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp2.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp3.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp4.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp5.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp1.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp7.setTextColor(ContextCompat.getColor(activity(), R.color.black));
            chipSp8.setTextColor(ContextCompat.getColor(activity(), R.color.colorPrimary));

            chipSp1.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp2.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp3.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp4.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp5.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp6.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp7.setChipBackgroundColor(generateColorStateList(R.color.app_background_color));
            chipSp8.setChipBackgroundColor(generateColorStateList(R.color.light_color_primary));

            chipSp1.setChipIconVisible(false);
            chipSp2.setChipIconVisible(false);
            chipSp3.setChipIconVisible(false);
            chipSp4.setChipIconVisible(false);
            chipSp5.setChipIconVisible(false);
            chipSp6.setChipIconVisible(false);
            chipSp7.setChipIconVisible(false);
            chipSp8.setChipIconVisible(true);

            iSpeedController.setPlaybackSpeed(PlayBackSpeed.SP2X);
            this.dismiss();

        });
    }

    public ColorStateList generateColorStateList(int color) {
        int[][] states = new int[][]{

                new int[]{android.R.attr.state_checked}, // disabled
                new int[]{-android.R.attr.state_checked}, // unchecked
                new int[]{android.R.attr.state_pressed}  // pressed
        };

        int[] colors = new int[]{

                ContextCompat.getColor(activity(), color),
                ContextCompat.getColor(activity(), color),
                ContextCompat.getColor(activity(), color)
        };

        return new ColorStateList(states, colors);

    }

    @Override
    public void changeTitle(String title) {

    }

    @Override
    public void showSnackBar(String snackBarText, int type) {

    }

    @Override
    public Activity activity() {
        return getActivity();
    }
}
