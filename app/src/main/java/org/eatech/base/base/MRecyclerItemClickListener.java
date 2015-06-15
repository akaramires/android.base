/**
 * Created by Elmar <a.k.a. Ramires> Abdurayimov on 6/8/15 3:36 PM
 *
 * @copyright (C)Copyright 2014 e.abdurayimov@gmail.com
 */

package org.eatech.base.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class MRecyclerItemClickListener implements RecyclerView.OnItemTouchListener
{
    private OnItemClickListener mListener;

    public interface OnItemClickListener
    {
        public void onItemClick(View view, int position);
    }

    GestureDetector mGestureDetector;

    public MRecyclerItemClickListener(Context context, OnItemClickListener listener)
    {
        mListener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener()
        {

            @Override
            public boolean onSingleTapUp(MotionEvent e)
            {
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e)
    {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            mListener.onItemClick(childView, view.getChildPosition(childView));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent)
    {
    }
}