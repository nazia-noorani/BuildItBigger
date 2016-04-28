package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import nazianoorani.myandroidlib.MainActivityLib;

/**
 * Created by nazianoorani on 27/04/16.
 */

public class MainFragment extends Fragment {



    private String joke;
    private InterstitialAd mInterstitialAd;
    public MainFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getString(R.string.ad_unit_id));
        requestNewInterstitial();

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                Intent intent = new Intent(getActivity(), MainActivityLib.class);
                intent.putExtra("joke",joke);
                startActivity(intent);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

//        AdView mAdView = (AdView) root.findViewById(R.id.adView);
//        // Create an ad request. Check logcat output for the hashed device ID to
//        // get test ads on a physical device. e.g.
//        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
//        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .build();
//        mAdView.loadAd(adRequest);
        return root;
    }

    public void printJoke(){
        if(mInterstitialAd.isLoaded()){
            Log.i("add is Loaded","YES");
            mInterstitialAd.show();
            Log.i("add is showing","YES");
        }else {

            Log.i("add is Loaded","NO");
            Intent intent = new Intent(getActivity(), MainActivityLib.class);
            intent.putExtra("joke",joke);
            startActivity(intent);
        }
    }

    private void requestNewInterstitial() {
        Log.i("request","request made!");
        // enter device id for the add to show on a particular device
        AdRequest adRequest = new AdRequest.Builder()
        .addTestDevice("FB1F26C5B5A548231768D910133CC405")
                .build();
        mInterstitialAd.loadAd(adRequest);
        Log.i("requestttt","request to load!");
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}
