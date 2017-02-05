package com.uudon.learner.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.uudon.learner.QuestionConstants;
import com.uudon.learner.R;
import com.uudon.learner.adapter.AnswerRightCallBack;
import com.uudon.learner.adapter.FreeQuestionAdapter;
import com.uudon.learner.bean.SimpleQuestionInfo;
import com.uudon.learner.dialog.BottomDialog;
import com.uudon.learner.utils.Logger;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;


/**
 * 每日十题界面
 * Created by 施行 on 2016/12/27.
 */

public class FreeQuestionActivity extends BaseAcitivty {

    final String TAG = getClass().getName();

    private static final int MSG_SHOW_LIST_DATA = 101;
    private ViewPager mViewPager;
    private List<SimpleQuestionInfo> mQuestionInfos = null;
    private FreeQuestionAdapter mFreeQuestionAdapter;
    private TextView mTvAnswer,mTvCount;
    private Button mBtnAnalysis;
    private BottomDialog mBottomDialog = null;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, FreeQuestionActivity.class);
        context.startActivity(intent);
    }

    private Handler mHander = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case MSG_SHOW_LIST_DATA:
                    updataList();
                break;
            }
        }
    };

    private void updataList() {
        mFreeQuestionAdapter.setAdapterData(getViewList(mQuestionInfos),mQuestionInfos);
        mFreeQuestionAdapter.notifyDataSetChanged();
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_free_question;
    }

    @Override
    protected void preInitView() {
        initDialog();
        initActionBar();
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTvAnswer = (TextView) findViewById(R.id.tv_answer);
        mTvCount = (TextView) findViewById(R.id.tv_count);

        mBtnAnalysis = (Button) findViewById(R.id.btn_analysis);
        mBtnAnalysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBottomDialog.show();
            }
        });

    }

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back_selector);
    }

    private void initDialog() {
        if (mBottomDialog == null) {
            mBottomDialog = new BottomDialog(getContext());
        }
    }

    @Override
    protected void preInitData() {
        showLoading();
        initAdapter();
        loadQuestions();
        bindingEvent();

    }

    private void initAdapter(){
        if (mFreeQuestionAdapter == null) {
            mFreeQuestionAdapter = new FreeQuestionAdapter(getContext());
        }
        mFreeQuestionAdapter.setAnswerRightCallBack(new AnswerRightCallBack() {
            @Override
            public void onAnswerRight(SimpleQuestionInfo simpleQuestionInfo) {
                mTvAnswer.setText(getResources().getString(R.string.answer_right, simpleQuestionInfo.getCorrectAnswer()));
                mBottomDialog.setDialogContent(simpleQuestionInfo.getAnalysis());
                mBtnAnalysis.setVisibility(View.VISIBLE);
            }
        });

        mViewPager.setAdapter(mFreeQuestionAdapter);
    }
    private void bindingEvent() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                SimpleQuestionInfo simpleQuestionInfo = mQuestionInfos.get(position);
                if (simpleQuestionInfo.isDone()) {
                    mTvAnswer.setText(getResources().getString(R.string.answer_right, simpleQuestionInfo.getCorrectAnswer()));
                    mBottomDialog.setDialogContent(simpleQuestionInfo.getAnalysis());
                    mBtnAnalysis.setVisibility(View.VISIBLE);
                } else {
                    mTvAnswer.setText(getResources().getString(R.string.answer_null));
                    mBtnAnalysis.setVisibility(View.INVISIBLE);
                }
                String text = Integer.toString(position + 1) + "/" + Integer.toString(mQuestionInfos.size());
                mTvCount.setText(text);
                Log.e(TAG, simpleQuestionInfo.isDone() + "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private List<View> getViewList(List<SimpleQuestionInfo> simpleQuestionInfos) {
        List<View> viewList = new ArrayList<View>();
        LayoutInflater inflater = getLayoutInflater();

        for (SimpleQuestionInfo info : simpleQuestionInfos) {
            if (info.getOptionType() == QuestionConstants.QUESTION_TYPE_TRUE_OR_FALSE) {
                viewList.add(inflater.inflate(R.layout.pager_item_tf_question_templet, null));
            } else if (info.getOptionType() == QuestionConstants.QUESTION_TYPE_SELECT_THREE) {
                viewList.add(inflater.inflate(R.layout.pager_item_select_3_question_templet, null));
            } else if (info.getOptionType() == QuestionConstants.QUESTION_TYPE_SELECT_FOUR) {
                viewList.add(inflater.inflate(R.layout.pager_item_select_4_question_templet, null));
            }
        }

        return viewList;
    }

    private void loadQuestions() {
        showLoading();
        mQuestionInfos = new ArrayList<SimpleQuestionInfo>();
        BmobQuery<SimpleQuestionInfo> bmobQuery = new BmobQuery<SimpleQuestionInfo>();
        bmobQuery.setLimit(1000);
        bmobQuery.findObjects(new FindListener<SimpleQuestionInfo>() {
            @Override
            public void done(List<SimpleQuestionInfo> list, BmobException e) {
                if (e == null) {
                    hideLoading();
                    //查询成功
                    mQuestionInfos.addAll(list);
                    mHander.sendEmptyMessage(MSG_SHOW_LIST_DATA);
                    Logger.e(TAG, "list.size:" + list.size());
                } else {
                    //查询失败
                    toast("更新失败");
                    hideLoading();
                }
            }
        });
    }

    @Override
    protected int getTitleStringID() {
        return R.string.free_question_activity;
    }

    private void showView(View view) {
        if (null == view) {
            return;
        }

        if (View.VISIBLE != view.getVisibility()) {
            view.setVisibility(View.VISIBLE);
        }
    }

    private void hideView(View view) {
        if (null == view) {
            return;
        }
        if (View.GONE != view.getVisibility()) {
            view.setVisibility(View.GONE);
        }

        return;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
