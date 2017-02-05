package com.uudon.learner.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.uudon.learner.QuestionConstants;
import com.uudon.learner.R;
import com.uudon.learner.bean.SimpleQuestionInfo;
import com.uudon.learner.helper.XUtilsBtimapHelper;

import java.util.ArrayList;
import java.util.List;

import static com.uudon.learner.helper.XUtilsBtimapHelper.getBitmapUtils;

/**
 * Created by ShiXing on 2016/12/29.
 */

/**
 * 实现一个PagerAdapter时，至少需要覆盖以下几个方法：
 *       instantiateItem(ViewGroup, int)
         destroyItem(ViewGroup, int, Object)
         getCount()
         isViewFromObject(View, Object)
 */

public class FreeQuestionAdapter extends PagerAdapter {

    public AnswerRightCallBack mAnswerRightCallBack;

    final String TAG = getClass().getName();
    List<View> mViews = new ArrayList<View>();
    List<SimpleQuestionInfo> mQuestionInfos = null;
    Context mContext = null;
    private static final int SELECT_A = 1;
    private static final int SELECT_B = 2;
    private static final int SELECT_C = 3;
    private static final int SELECT_D = 4;
    BitmapUtils mBitmapUtils = null;

    public FreeQuestionAdapter(Context context) {
        this.mContext = context;
        mBitmapUtils = XUtilsBtimapHelper.getBitmapUtils(mContext);
    }

    public void setAdapterData(List<View> views, List<SimpleQuestionInfo> questionInfos){
        this.mViews = views;
        this.mQuestionInfos = questionInfos;
    }

    public void setAnswerRightCallBack(AnswerRightCallBack callBack){
        mAnswerRightCallBack = callBack;
    }

    @Override
    public int getCount() {
        return mViews.size() == 0 || mViews == null ? 0 : mViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViews.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mViews.get(position);
        SimpleQuestionInfo questionInfo = mQuestionInfos.get(position);
        TextView questionTilte = (TextView) view.findViewById(R.id.question_title);
        TextView tvType = (TextView) view.findViewById(R.id.tv_type);

        Button answerA = (Button) view.findViewById(R.id.answer_a);
        Button answerB = (Button) view.findViewById(R.id.answer_b);
        answerA.setText(String.format(mContext.getResources().getString(R.string.answer_a),questionInfo.getOptionA()));
        answerB.setText(String.format(mContext.getResources().getString(R.string.answer_b),questionInfo.getOptionB()));
        if(questionInfo.getOptionType() == QuestionConstants.QUESTION_TYPE_TRUE_OR_FALSE){
            tvType.setText(mContext.getString(R.string.question_tf));
            onItemOnClick(questionInfo,answerA,answerB,null,null);
        }else if(questionInfo.getOptionType() == QuestionConstants.QUESTION_TYPE_SELECT_THREE){
            Button answerC = (Button) view.findViewById(R.id.answer_c);
            answerC.setText(String.format(mContext.getResources().getString(R.string.answer_c),questionInfo.getOptionC()));
            tvType.setText(mContext.getString(R.string.question_select));
            onItemOnClick(questionInfo,answerA,answerB,answerC,null);
        }else if(questionInfo.getOptionType() == QuestionConstants.QUESTION_TYPE_SELECT_FOUR){
            Button answerC = (Button) view.findViewById(R.id.answer_c);
            Button answerD = (Button) view.findViewById(R.id.answer_d);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_picture);
            tvType.setText(mContext.getString(R.string.question_select));
            answerC.setText(String.format(mContext.getResources().getString(R.string.answer_c),questionInfo.getOptionC()));
            answerD.setText(String.format(mContext.getResources().getString(R.string.answer_d),questionInfo.getOptionD()));
            mBitmapUtils.display(imageView,questionInfo.getPictureUrl());
            onItemOnClick(questionInfo,answerA,answerB,answerC,answerD);
        }
        questionTilte.setText(questionInfo.getTitle());
        container.addView(mViews.get(position));
        return mViews.get(position);
    }

    private void onItemOnClick(SimpleQuestionInfo simpleQuestionInfo,final Button answerA,final Button answerB,final Button answerC,final Button answerD) {
        final SimpleQuestionInfo questionInfo = simpleQuestionInfo;
        if(answerA != null){
            answerA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onSwichCorrectAnswer(questionInfo,SELECT_A,answerA);
                }
            });
        }
        if(answerB != null){
            answerB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onSwichCorrectAnswer(questionInfo,SELECT_B,answerB);
                }
            });
        }
        if(answerC != null){
            answerC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onSwichCorrectAnswer(questionInfo,SELECT_C,answerC);
                }
            });
        }
        if(answerD != null){
            answerD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onSwichCorrectAnswer(questionInfo,SELECT_D,answerD);
                }
            });
        }
    }

    private void onSwichCorrectAnswer(SimpleQuestionInfo simpleQuestionInfo, int getSelectId, Button button){
        switch (getSelectId){
            case SELECT_A:
                isCorrectAnswer(simpleQuestionInfo, simpleQuestionInfo.getOptionA(),button);
                break;
            case SELECT_B:
                isCorrectAnswer(simpleQuestionInfo, simpleQuestionInfo.getOptionB(),button);
                break;
            case SELECT_C:
                isCorrectAnswer(simpleQuestionInfo, simpleQuestionInfo.getOptionC(),button);
                break;
            case SELECT_D:
                isCorrectAnswer(simpleQuestionInfo, simpleQuestionInfo.getOptionD(),button);
                break;
        }
    }

    private void isCorrectAnswer(SimpleQuestionInfo simpleQuestionInfo, String option,Button button) {
        if (simpleQuestionInfo.isCorrectAnswer(option)) {
           // Toast.makeText(mContext, "答案正确", Toast.LENGTH_SHORT).show();
            simpleQuestionInfo.setDone(true);
            button.setTextColor(mContext.getResources().getColor(R.color.colorRed));
            mAnswerRightCallBack.onAnswerRight(simpleQuestionInfo);
        } else {
           //Toast.makeText(mContext, "答案错误", Toast.LENGTH_SHORT).show();
            Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.rotate);
            button.startAnimation(animation);
        }
    }
}
