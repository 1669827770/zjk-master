package view;


import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import java.util.ArrayList;

import ui.activity.video.SingleCallback;
import util.ScreenUtils;
import util.TrimVideoUtil;
import util.UiThreadExecutor;
import videodemo.R;

import static videodemo.MyApplication.mContext;

public class VideoTrimmerView extends FrameLayout {

    /**
     * 计算公式:
     * PixRangeMax = (视频总长 * SCREEN_WIDTH) / 视频最长的裁剪时间(15s)
     * 视频总长/PixRangeMax = 当前视频的时间/游标当前所在位置
     */

    /**
     * 控件
     */
    private VideoView vv_trimvideo;
    private RelativeLayout rl_trimcontainer;
    private RecyclerView rl_trimpictureRecycleview;
    private ImageView iv_leftbar;
    private ImageView iv_rightbar;

    ArrayList<Bitmap> bitmaps;
    HomeAdapter homeAdapter;


    int  lastLeftX;
    int  lastRightX;



    public VideoTrimmerView(Context context) {
        this(context, null);
    }

    public VideoTrimmerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VideoTrimmerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        LayoutInflater.from(context).inflate(R.layout.video_trimmer_view, this, true);

        vv_trimvideo = findViewById(R.id.vv_trimvideo);
        rl_trimcontainer = findViewById(R.id.rl_trimcontainer);
        rl_trimpictureRecycleview = findViewById(R.id.rl_trimpictureRecycleview);
        iv_leftbar = findViewById(R.id.iv_leftbar);
        iv_rightbar = findViewById(R.id.iv_rightbar);

        bitmaps = new ArrayList<>();

        homeAdapter = new HomeAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rl_trimpictureRecycleview.setLayoutManager(linearLayoutManager);
        rl_trimpictureRecycleview.setAdapter(homeAdapter);





        iv_leftbar.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int X = (int) motionEvent.getRawX();

                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        lastLeftX = (int) motionEvent.getRawX();
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int dx = (int) motionEvent.getRawX() - lastLeftX;

                        int left = iv_leftbar.getLeft() + dx;

                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) iv_leftbar
                                .getLayoutParams();

                        layoutParams.leftMargin =left;
                        view.setLayoutParams(layoutParams);
                        lastLeftX = (int) motionEvent.getRawX();
                        break;
                }
                iv_leftbar.invalidate();
                return true;
            }
        });

        iv_rightbar.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int X = (int) motionEvent.getRawX();

                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        lastRightX = (int) motionEvent.getRawX();
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int dx = (int) motionEvent.getRawX() - lastRightX;

                        int left = iv_rightbar.getLeft() + dx;

                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) iv_rightbar
                                .getLayoutParams();

                        layoutParams.leftMargin =left;
                        view.setLayoutParams(layoutParams);
                        lastRightX = (int) motionEvent.getRawX();
                        break;
                }
                iv_rightbar.invalidate();
                return true;
            }
        });

    }


    public void setVideoPath(String videoPath) {

        placevideo(videoPath);

        /**
        *   获取视频时长
        */
        MediaMetadataRetriever retr = new MediaMetadataRetriever();
        retr.setDataSource(videoPath);
        String time = retr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);//获取视频时长

        Long aLong = Long.valueOf(time);
        Log.d("0000000000000000000000", "[" + time + "]");


        int screenWidth = ScreenUtils.getScreenWidth();
        int i = (int) (screenWidth * (11/20f));


        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) iv_rightbar
                .getLayoutParams();

        layoutParams.leftMargin =i;
        iv_rightbar.setLayoutParams(layoutParams);
        iv_rightbar.invalidate();



        /**
         * 将String路径转为URi类型的
         */
        Uri pathUri = Uri.parse(videoPath);


        //重点来了就是剪切视频的工具类
        TrimVideoUtil.backgroundShootVideoThumb(1,mContext, pathUri, new SingleCallback<ArrayList<Bitmap>, Integer>() {
            @Override
            public void onSingleCallback(final ArrayList<Bitmap> bitmap, final Integer interval) {
                UiThreadExecutor.runTask("", new Runnable() {
                    @Override
                    public void run() {
                        //讲补获到的截屏添加到listview的Adapter中
                        bitmaps.addAll(bitmap);
                        homeAdapter.notifyDataSetChanged();




                    }
                }, 0L);

            }
        });



    }

    public void placevideo(String videoPath) {
        //设置视频路径
        vv_trimvideo.setVideoURI(Uri.parse(videoPath));
        //开始播放视频
        vv_trimvideo.start();

    }


//
//    int lastX;
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Log.e("333333333", ""+"999999999999");
//        int action = event.getAction();
//
//        switch (action) {
//            case MotionEvent.ACTION_DOWN: {
//                lastX = (int) event.getRawX();
//
//                return true;
//            }
//            case MotionEvent.ACTION_UP: {
//
//                return true;
//            }
//
//            case MotionEvent.ACTION_MOVE: {
//                    int dx = (int) event.getRawX() - lastX;
//                    int left = iv_leftbar.getLeft() + dx;
//                    Log.e("333333333", ""+left);
//                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) iv_leftbar
//                            .getLayoutParams();
////                layoutParams.height=IMAGE_SIZE;
////                layoutParams.width = IMAGE_SIZE;
//                    layoutParams.leftMargin =left;
//                    iv_leftbar.setLayoutParams(layoutParams);
//                iv_leftbar.invalidate();
//                return true;
//            }
//
//            }
//        invalidate();
//        return false;
//    }

    //    int lastX;
//    @Override
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//
//
//            switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
//                case MotionEvent.ACTION_DOWN:
//                    lastX = (int) motionEvent.getRawX();
//                    break;
//                case MotionEvent.ACTION_UP:
//                    break;
//
//                case MotionEvent.ACTION_MOVE:
//                    int dx = (int) motionEvent.getRawX() - lastX;
//                    int left = iv_leftbar.getLeft() + dx;
//                    Log.e("333333333", ""+left);
//                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) iv_leftbar
//                            .getLayoutParams();
////                layoutParams.height=IMAGE_SIZE;
////                layoutParams.width = IMAGE_SIZE;
//                    layoutParams.leftMargin =left;
//                    iv_leftbar.setLayoutParams(layoutParams);
//                    break;
//            }
//        iv_leftbar.invalidate();
//            return true;
//
//    }


    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>
    {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_videoscreenshot, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position)
        {

            holder.img_screenshot.setImageBitmap(bitmaps.get(position));
        }

        @Override
        public int getItemCount()
        {
            return bitmaps.size();

        }



        class MyViewHolder extends RecyclerView.ViewHolder
        {
            ImageView img_screenshot;

            public MyViewHolder(View view)
            {
                super(view);
                img_screenshot = (ImageView) view.findViewById(R.id.img_screenshot);
            }
        }
    }


}
