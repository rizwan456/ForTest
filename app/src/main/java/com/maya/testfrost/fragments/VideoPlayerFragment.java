package com.maya.testfrost.fragments;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.LoopingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.maya.testfrost.R;
import com.maya.testfrost.constants.Constants;
import com.maya.testfrost.interfaces.fragments.IFragment;
import com.maya.testfrost.utils.Utility;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideoPlayerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoPlayerFragment extends Fragment implements IFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.playerView)
    PlayerView playerView;

    @BindView(R.id.imgClose)
    ImageView imgClose;

    @BindView(R.id.imgResize)
    ImageView imgResize;

    @BindView(R.id.llPlayer)
    LinearLayout llPlayer;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    Uri uri;


    private SimpleExoPlayer player;

    private Timeline.Window window;
    private DefaultTrackSelector trackSelector;
    private boolean shouldAutoPlay;
    private BandwidthMeter bandwidthMeter;


    public VideoPlayerFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static VideoPlayerFragment newInstance(Uri uri) {
        VideoPlayerFragment fragment = new VideoPlayerFragment();
        Bundle args = new Bundle();
        args.putParcelable("Uri", uri);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            uri = getArguments().getParcelable("Uri");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video_player, container, false);
        ButterKnife.bind(this, view);

        setUp();
        return view;
    }

    private void setUp() {
        shouldAutoPlay = true;
        bandwidthMeter = new DefaultBandwidthMeter();
        window = new Timeline.Window();

        imgClose.setOnClickListener(v -> {
            releasePlayer();
            activity().onBackPressed();
        });

        imgResize.setOnClickListener(v ->
        {
            if (playerView != null) {
                imgResize.setImageResource(activity().getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE ? R.drawable.exo_controls_fullscreen_enter : R.drawable.exo_controls_fullscreen_exit);
                activity().setRequestedOrientation(activity().getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE ? ActivityInfo.SCREEN_ORIENTATION_PORTRAIT : ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                //decorateUi();
            }

        });


    }


    private void initializePlayer() {

        if (uri == null) {
            return;
        }
        if (player != null) {
            return;
        }
        playerView.requestFocus();

        bandwidthMeter = new DefaultBandwidthMeter();


        TrackSelection.Factory videoTrackSelectionFactory =
                new AdaptiveTrackSelection.Factory();

        trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);
        // Here

        player = ExoPlayerFactory.newSimpleInstance(activity(), trackSelector);
        playerView.setControllerHideOnTouch(true);
        playerView.setControllerShowTimeoutMs(1500);
        playerView.setPlayer(player);
        player.setPlayWhenReady(shouldAutoPlay);



        MediaSource mediaSource = buildMediaSource(uri);

        LoopingMediaSource loopingSource = new LoopingMediaSource(mediaSource);
        player.prepare(loopingSource);


        player.addListener(new Player.EventListener() {
            @Override
            public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {

            }

            @Override
            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

            }

            @Override
            public void onLoadingChanged(boolean isLoading) {

            }

            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                switch (playbackState) {
                    case Player.STATE_IDLE:
                        progressBar.setVisibility(View.GONE);
                        break;
                    case Player.STATE_BUFFERING:
                        progressBar.setVisibility(View.VISIBLE);

                        break;
                    case Player.STATE_READY:
                        progressBar.setVisibility(View.GONE);

                        break;
                    case Player.STATE_ENDED:
                        progressBar.setVisibility(View.GONE);

                        break;
                }
            }

            @Override
            public void onRepeatModeChanged(int repeatMode) {

            }

            @Override
            public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

            }

            @Override
            public void onPlayerError(ExoPlaybackException error) {

            }

            @Override
            public void onPositionDiscontinuity(int reason) {

            }

            @Override
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

            }

            @Override
            public void onSeekProcessed() {

            }
        });
    }


    private MediaSource buildMediaSource(Uri uri)
    {

        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(activity(), Util.getUserAgent(activity(), "IPOLL"));

        if (uri.getLastPathSegment().contains("mp3") || uri.getLastPathSegment().contains("mp4")) {
            return new ExtractorMediaSource.Factory(new DefaultHttpDataSourceFactory("IPOLL"))
                    .createMediaSource(uri);
        } else if (uri.getLastPathSegment().contains("m3u8")) {
            DefaultHlsExtractorFactory defaultHlsExtractorFactory = new DefaultHlsExtractorFactory(DefaultTsPayloadReaderFactory.FLAG_ALLOW_NON_IDR_KEYFRAMES);
            return new HlsMediaSource.Factory(dataSourceFactory)
                    .setExtractorFactory(defaultHlsExtractorFactory)
                    .createMediaSource(uri);
        } else {
            DashChunkSource.Factory dashChunkSourceFactory = new DefaultDashChunkSource.Factory(dataSourceFactory);
            DataSource.Factory manifestDataSourceFactory = new DefaultHttpDataSourceFactory("IPOLL");
            return new DashMediaSource.Factory(dashChunkSourceFactory, manifestDataSourceFactory).createMediaSource(uri);
        }
    }

    private void releasePlayer() {
        if (player != null) {
            shouldAutoPlay = player.getPlayWhenReady();
            player.release();
            player = null;
            trackSelector = null;
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        if (player == null) {
            initializePlayer();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (player == null) {
            initializePlayer();
        } else {
            shouldAutoPlay = true;
            player.setPlayWhenReady(true);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (player == null) {

        } else {
            shouldAutoPlay = false;
            player.setPlayWhenReady(false);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT <= 23) {
            releasePlayer();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        releasePlayer();
    }


    private void hideSystemUi() {
        playerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
    }


    private void decorateUi() {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                View decorView = activity().getWindow().getDecorView();
                int uiOptions =
                         View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
                decorView.setSystemUiVisibility(uiOptions);
            }
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
