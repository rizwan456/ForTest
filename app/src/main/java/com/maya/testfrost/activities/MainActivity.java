package com.maya.testfrost.activities;

import android.app.Activity;
import android.net.Uri;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.maya.testfrost.R;
import com.maya.testfrost.adapters.RootAdapter;
import com.maya.testfrost.fragments.VideoPlayerFragment;
import com.maya.testfrost.interfaces.activities.IActivity;
import com.maya.testfrost.interfaces.adapters.IRootAdapter;
import com.maya.testfrost.models.Element;
import com.maya.testfrost.models.Tree;
import com.maya.testfrost.models.VideoDetails;
import com.maya.testfrost.network.retrofit2.AppRetrofitAdapter;
import com.maya.testfrost.services.IVideoService;
import com.maya.testfrost.utils.Utility;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements IActivity, IRootAdapter {



    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.tvTitle)
    TextView tvTitle;


    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;

    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;

     @BindView(R.id.nav_view)
     NavigationView navigationView;

    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;

    Handler handler;

    RecyclerView recyclerView;

    List<Tree> treeList;

    RootAdapter rootAdapter;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setUp();
    }

    private void setUp()
    {

        handler = new Handler();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_apps);

        setupDrawerToggle();

        // side navigation menu

        recyclerView = navigationView.getHeaderView(0).findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity()));

        new Handler().postDelayed(() ->
        {
           recyclerView.setAdapter(rootAdapter = new RootAdapter(treeList = Utility.generateTrees(),activity(),this));
        },200);
    }


    private void setupDrawerToggle()
    {
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(activity(), drawer, toolbar, R.string.app_name, R.string.app_name);
        mDrawerToggle.setDrawerIndicatorEnabled(false);
        mDrawerToggle.syncState();
        mDrawerToggle.setToolbarNavigationClickListener(v ->
        {
            drawer.openDrawer(GravityCompat.START);
        });

        changeTitle("Root View");



        addVideoPlayer();


    }

    private void addVideoPlayer()
    {
        if(Utility.isNetworkAvailable(activity()))
        {
            progressBar.setVisibility(View.VISIBLE);

            Observer<JsonObject> observer = new Observer<JsonObject>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(JsonObject jsonObject) {
                    Log.d("DATA",jsonObject.toString());
                    progressBar.setVisibility(View.GONE);

                    new CheckVideo(jsonObject).start();



                }

                @Override
                public void onError(Throwable e) {
                    progressBar.setVisibility(View.GONE);
                    showSnackBar("Something went wrong",2);

                }

                @Override
                public void onComplete() {

                }
            };

            AppRetrofitAdapter.getRetrofit().create(IVideoService.class).getVideo()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(observer);


        }
        else
        {
            showSnackBar("Please check Internet",2);
        }
    }

    private void playVideo(String videoUrl)
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, VideoPlayerFragment.newInstance(Uri.parse(videoUrl))).commit();
    }


    @Override
    public void changeTitle(String title) {
        tvTitle.setText(title);
    }

    @Override
    public void showSnackBar(String snackBarText, int type) {
        Utility.showSnackBar(activity(),coordinatorLayout,snackBarText,type);
    }

    @Override
    public Activity activity() {
        return this;
    }

    @Override
    public void changeView(Tree tree, int position) {
        treeList.get(position).isOpen =   treeList.get(position).isOpen ? false : true;
        rootAdapter.notifyItemChanged(position);
    }


    public class CheckVideo extends Thread
    {
        JsonObject jsonObject;
        public CheckVideo(JsonObject jsonObject)
        {
            this.jsonObject = jsonObject;
        }
        @Override
        public void run() {
            super.run();

            Gson gson = new Gson();
            Type type = new TypeToken<List<Element>>(){}.getType();

            List<Element> elements = gson.fromJson(jsonObject.getAsJsonObject("content").get("innerData"),type);
            if(elements!=null && elements.size()>0)
            {
                for (int i =0;i<elements.size();i++)
                {
                    for (int k = 0;k<elements.get(i).children.size();k++) {
                        if (elements.get(i).children.get(k).tagName.equals("lazy-dashboard-video")) {

                            for (int j = 0; j < elements.get(i).children.get(k).attributes.size(); j++) {
                                if (elements.get(i).children.get(k).attributes.get(j).key.equals("video_data")) {
                                    String content = elements.get(i).children.get(k).attributes.get(j).value;
                                    content = content.replaceAll("&quot;", "\"");
                                    Log.d("content",content);
                                    JsonArray jsonArray = new JsonParser().parse(content).getAsJsonArray();

                                    if (jsonArray != null && jsonArray.size() > 0) {
                                        Type type1 = new TypeToken<VideoDetails>() {
                                        }.getType();
                                        VideoDetails videoDetails = gson.fromJson(jsonArray.get(0).getAsJsonObject().get("videoDetails"), type1);
                                        if (videoDetails != null) {

                                            handler.post(() ->
                                            {
                                                playVideo(videoDetails.videoUrl);
                                                showSnackBar(videoDetails.videoUrl, 2);
                                            });

                                        }
                                        else
                                        {
                                            handler.post(() -> {
                                                showSnackBar("Video not found", 2);
                                            });
                                        }
                                    }

                                    break;
                                }
                            }

                            break;
                        }
                    }
                }
            }

        }
    }
}
