package view;


import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import videodemo.R;

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
    private RecyclerView rl_trimpicture;
    private ImageView iv_leftbar;
    private ImageView iv_rightbar;


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
        rl_trimpicture = findViewById(R.id.rl_trimpicture);
        iv_leftbar = findViewById(R.id.iv_leftbar);
        iv_rightbar = findViewById(R.id.iv_rightbar);

    }


    public void setVideoPath(String videoPath) {

        placevideo(videoPath);

        /**
        *   获取视频时长
        */
        MediaMetadataRetriever retr = new MediaMetadataRetriever();
        retr.setDataSource(videoPath);
        String time = retr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);//获取视频时长


        //重点来了就是剪切视频的工具类
//        TrimVideoUtil.backgroundShootVideoThumb(1,mContext, mSrc, new SingleCallback<ArrayList<Bitmap>, Integer>() {
//            @Override
//            public void onSingleCallback(final ArrayList<Bitmap> bitmap, final Integer interval) {
//                UiThreadExecutor.runTask("", new Runnable() {
//                    @Override
//                    public void run() {
//                        //讲补获到的截屏添加到listview的Adapter中
//                        bitmaps.addAll(bitmap);
//                        if (bitmaps.size()*accuracy>thumb_Width){
//                            bitmaps.addAll(bitmap);
//
//                            videoThumbAdapter.addAll(bitmap);
//                        }
//                        videoThumbAdapter.addAll(bitmap);
//                        videoThumbAdapter.notifyDataSetChanged();
//                    }
//                }, 0L);
//
//            }
//        });

    }

    public void placevideo(String videoPath) {
        //设置视频路径
        vv_trimvideo.setVideoURI(Uri.parse(videoPath));
        //开始播放视频
        vv_trimvideo.start();

    }


}
