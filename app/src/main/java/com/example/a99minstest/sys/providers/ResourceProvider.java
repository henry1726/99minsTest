package com.example.a99minstest.sys.providers;

import android.content.Context;

import javax.inject.Inject;

public class ResourceProvider {
    private Context context;

    @Inject
    public ResourceProvider(Context context) {
        this.context = context;
    }
}
