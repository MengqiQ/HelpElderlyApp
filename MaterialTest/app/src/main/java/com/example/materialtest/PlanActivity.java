package com.example.materialtest;

/**
 * Created by mengqiqin on 17/4/8.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PlanActivity extends AppCompatActivity {

    public static final String PLAN_NAME = "plan_name";

    public static final String PLAN_IMAGE_ID = "plan_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        Intent intent = getIntent();
        String planName = intent.getStringExtra(PLAN_NAME);
        int planImageId = intent.getIntExtra(PLAN_IMAGE_ID, 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView planImageView = (ImageView) findViewById(R.id.plan_image_view);
        TextView planContentText = (TextView) findViewById(R.id.plan_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(planName);
        Glide.with(this).load(planImageId).into(planImageView);
        String planContent = generatePlanContent(planName);
        planContentText.setText(planContent);
    }

    private String generatePlanContent(String planName) {
        StringBuilder planContent = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            planContent.append(planName);
        }
        return planContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

