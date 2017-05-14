package activity.video;


import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;

import activity.SViewOrRviewBattleActivity;
import util.Utils;
import videodemo.R;
import view.FullyGridLayoutManager;
import view.MyRecycleview;


/**
 * Created by zhangbing on 2017-05-12.
 * 知识点：recyclevbiew与ScroLLview的冲突
 *
 */

public class ChooseVideoFragment extends Fragment implements View.OnTouchListener,View.OnClickListener {
    int k =1;
    private int lastX, lastY;
    boolean isCompressIng = false;
    MyScrollview  my_scrollView;
    ImageView change_video;
    private Button toTopBtn;// 返回顶部的按钮
    private int scrollY = 0;// 标记上次滑动位置
    private View contentView;


    //视频压缩部分常量
    Double videoLength = 0.0;//视频时长
    //视频压缩数据地址
    private String currentOutputVideoPath = "/mnt/sdcard/out.mp4";
    File file;
    ProgressBar progressBar;

    private static final int SHOW_PROGRESS = 2;
    View messageLayout;
    public ArrayList<VideoInfo> allVideos;

    MyRecycleview mvideo_select_recyclerview;
    ImageView miv_back_topic2;
    Button mbtn_next;
    VideoView mvv;
//    ImageView mPlayView;   //点击播放暂停按钮
//    ImageView icon_video_thumbnail;
    Boolean isFirstPlay = true;

    GridLayoutManager manager;
    String videoPath;
    VideoGridViewAdapter videoGridViewAdapter;
    private ArrayList<VideoInfo> videoListData;
    private final MessageHandler mMessageHandler = new MessageHandler();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这个就是获取视频URi的核心方法，知道本方法，本类就ok了
        allVideos = getAllVideoFiles(getContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(allVideos.size()>0){
            //覆盖videoview的图


            ArrayList<VideoInfo> videoInfos = new ArrayList<>();
            for (int i = 0; i <allVideos.size() ; i++) {
                VideoInfo videoInfo = allVideos.get(i);
                String videoName = videoInfo.getVideoName();

                if(videoInfo.getDuration()>5000&&!videoName.contains("yang")){

                    videoInfos.add(videoInfo);

                }
            }
            videoPath = videoInfos.get(0).getVideoPath();
            this.videoListData = videoInfos;
            if(videoInfos.size()==0){
                Toast.makeText(getContext(),"您的手机内没有大于5秒的视频", Toast.LENGTH_SHORT).show();
            }

            videoGridViewAdapter = new VideoGridViewAdapter(getContext(), videoInfos);


            manager = new GridLayoutManager(getActivity(), 4);
            messageLayout = inflater.inflate(R.layout.fragment_video, container, false);

            mvideo_select_recyclerview = (MyRecycleview) messageLayout.findViewById(R.id.video_select_recyclerview);
            my_scrollView = (MyScrollview) messageLayout.findViewById(R.id.my_scrollView);
            miv_back_topic2 = (ImageView) messageLayout.findViewById(R.id.iv_back_topic2);
//            icon_video_thumbnail = (ImageView) messageLayout.findViewById(R.id.icon_video_thumbnail);
            mbtn_next = (Button) messageLayout.findViewById(R.id.btn_next);
            mvv = (VideoView) messageLayout.findViewById(R.id.vv);
//            mPlayView = ((ImageView) messageLayout.findViewById(R.id.icon_video_play));
            progressBar = (ProgressBar) messageLayout.findViewById(R.id.progressBar);

//            my_scrollView = (MyScrollview) messageLayout.findViewById(R.id.my_scrollView);
            change_video = (ImageView) messageLayout.findViewById(R.id.change_video);

//刚进来的时候就会播放，所以不需要缩略图
//            Glide.with(this).load(videoPath).thumbnail(0.1f).into(icon_video_thumbnail);
            mvideo_select_recyclerview.addItemDecoration(new SpacesItemDecoration(15));
            mvideo_select_recyclerview.setHasFixedSize(true);

            FullyGridLayoutManager fullyGridLayoutManager = new FullyGridLayoutManager(getActivity(), 4);
            mvideo_select_recyclerview.setNestedScrollingEnabled(false);
            mvideo_select_recyclerview.setLayoutManager(fullyGridLayoutManager);

            mvideo_select_recyclerview.setAdapter(videoGridViewAdapter);

            mvv.setOnTouchListener(this);

            miv_back_topic2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().finish();

                }
            });

            change_video.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(k==1){
//                    Toast.makeText(getActivity(), "1111111111", Toast.LENGTH_SHORT).show();
//                    float height = Utils.convertDpToPixel(getActivity(), 300);
//                    int screenWidth = Utils.getScreenWidth(getActivity());
//                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mvv.getLayoutParams();
//
//                    layoutParams.height= 10000;
//                    layoutParams.width=10000;
//                    mvv.setLayoutParams(layoutParams);
                        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
                        mmr.setDataSource(videoPath);
//                  String duration = mmr.extractMetadata(android.media.MediaMetadataRetriever.METADATA_KEY_DURATION);
                        String width = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH);
                        String height = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT);
//                  RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mvv.getLayoutParams();

//
//                    float videoHeigth = Utils.convertDpToPixel(getActivity(), 10000);
//                    int screenWidth = Utils.getScreenWidth(getContext());
//                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) videoHeigth, screenWidth);
//                    int measuredHeight = mvv.getMeasuredHeight();
//                    mvv.measure((int) videoHeigth,screenWidth);
//                    mvv.invalidate();
                        mvv.invalidate(0,0, 1000,1000);

//                    int screenHeight = Utils.getScreenHeight(getContext());
//                    layoutParams.height= (int) videoHeigth;
//                    layoutParams.width=screenWidth;
//                    mvv.setLayoutParams(layoutParams);
//                    mmr.release();
                        k=2;
                    }else if (k==2) {
                        float height = Utils.convertDpToPixel(getActivity(), 300);
                        int screenWidth = Utils.getScreenWidth(getActivity());
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mvv.getLayoutParams();
                        layoutParams.height= (int) height;
                        layoutParams.width=screenWidth;
                        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
                        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                        mvv.setLayoutParams(layoutParams);
                        k=1;
                    }

                }
            });

            //下一步的点击方法
            mbtn_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ChooseVideoFragment.this.videoPath == null) {
                        Toast.makeText(getActivity(), "请先选择视频", Toast.LENGTH_SHORT).show();
                        return;
                    }
//                isFirstPlay = true;
                    //获取视频时长  计算压缩进度用
                    MediaMetadataRetriever retr = new MediaMetadataRetriever();
                    retr.setDataSource(videoPath);
                    String time = retr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);//获取视频时长
                    int i = Integer.parseInt(time);
                    if(i<5000){
                        Toast.makeText(getActivity(), "视频不能低于5秒，请重新选择", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Intent intent = getActivity().getIntent();
//                    intent.setClass(getActivity(), TrimmerActivity.class);
                    intent.putExtra("chooseVideoFragment", videoPath);
                    startActivity(intent);
                    //解决视频裁剪界面返回来，vieoview没有照片展示问题   ,关闭掉还可以操作
//                    mPlayView.setVisibility(View.VISIBLE);
//                    icon_video_thumbnail.setVisibility(View.VISIBLE);
//                    Glide.with(getContext()).load(videoPath).thumbnail(0.1f).into(icon_video_thumbnail);


                }

            });

            final GestureDetector gestureDetector = new
                    GestureDetector(getContext(),
                    new GestureDetector.SimpleOnGestureListener() {
                        @Override
                        public boolean onSingleTapConfirmed(MotionEvent e) {

                            if(isFirstPlay){   //解决了视频返回来的时候播放那个连接的问题
                                onClickVideoPlayPause(allVideos.get(0).getVideoPath());
                            }else{
                                onClickVideoPlayPause(videoPath);
                            }
                            return true;
                        }
                    }
            );

            mvv.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, @NonNull MotionEvent event) {
                    gestureDetector.onTouchEvent(event);
                    return true;
                }
            });


            videoGridViewAdapter.setItemClickCallback(new SingleCallback<Boolean, VideoInfo>() {
                @Override
                public void onSingleCallback(Boolean isSelected, VideoInfo video) {
                    if (video != null) {
                        isFirstPlay = false;
                        ChooseVideoFragment.this.videoPath = video.getVideoPath();
                        placevideo(ChooseVideoFragment.this.videoPath);//播放视频
//                        mPlayView.setVisibility(View.INVISIBLE);
//                        icon_video_thumbnail.setVisibility(View.INVISIBLE);
                        my_scrollView.fullScroll(ScrollView.FOCUS_UP);
                    }

                }
            });

       placevideo(videoInfos.get(0).getVideoPath());//播放视频
//            mPlayView.setVisibility(View.INVISIBLE);
        }else {
            Toast.makeText(getContext(), "您的手机没有视频可获取喔", Toast.LENGTH_SHORT).show();
        }
        return messageLayout;
    }

//    @Override
//    public void refrsh(ArrayList<VideoInfo> videoInfos) {
//        placevideo(videoInfos.get(0).getVideoPath());//播放视频
//    }

    public void placevideo(String s) {
        //设置视频路径
        mvv.setVideoURI(Uri.parse(s));
        //开始播放视频
        mvv.start();
    }

    public boolean onTouch(MotionEvent event) {
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();
//                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) _view
//                        .getLayoutParams();
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = (int) event.getRawX() - lastX;
                int dy = (int) event.getRawY() - lastY;
                int left = mvv.getLeft() + dx;
                int top = mvv.getTop() + dy;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mvv
                        .getLayoutParams();
//                layoutParams.height=IMAGE_SIZE;
//                layoutParams.width = IMAGE_SIZE;
                layoutParams.leftMargin =left;
                layoutParams.topMargin =top;
                mvv.setLayoutParams(layoutParams);
                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();
                break;
        }
        mvv.invalidate();
        return true;
    }

    private void onClickVideoPlayPause(String s) {
        //如果一进来还没有点击播放过(或者点击下一步之后)，那么点击播放第一个，
//        icon_video_thumbnail.setVisibility(View.INVISIBLE);
        if (isFirstPlay) {
            //设置视频路径
            mvv.setVideoURI(Uri.parse(s));
            //开始播放视频
            mvv.start();
//            mPlayView.setVisibility(View.INVISIBLE);
            isFirstPlay = false;  //只要播放过，再点击就走else
        } else {

            if (mvv.isPlaying()) {
//                mPlayView.setVisibility(View.VISIBLE);
                mMessageHandler.removeMessages(SHOW_PROGRESS);
                mvv.pause();
            } else {
//                mPlayView.setVisibility(View.INVISIBLE);

//            if (mResetSeekBar) {
//                mResetSeekBar = false;
//                mVideoView.seekTo(mStartPosition);
//            }
//
                mMessageHandler.sendEmptyMessage(SHOW_PROGRESS);
                mvv.start();
            }
        }
    }

    /**
     * 需要设计成异步的
     *
     * @param mContext
     * @return
     */
    public ArrayList<VideoInfo> getAllVideoFiles(Context mContext) {
        VideoInfo video;
        ArrayList<VideoInfo> videos1 = new ArrayList<>();
        ContentResolver contentResolver = mContext.getContentResolver();
        try {
            Cursor cursor = contentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null,
                    null, null, MediaStore.Video.Media.DATE_MODIFIED + " desc");
            while (cursor.moveToNext()) {
                video = new VideoInfo();

                if (cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Media.DURATION)) != 0) {
                    video.setDuration(cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Media.DURATION)));
                    video.setVideoPath(cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA)));
                    video.setCreateTime(cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATE_ADDED)));
                    video.setVideoName(cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DISPLAY_NAME)));
                    videos1.add(video);
                }
            }

            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return videos1;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {


        return false;
    }

    @Override
    public void onClick(View v) {

    }




    private class MessageHandler extends Handler {

//        @NonNull
//        private final WeakReference<HgLVideoTrimmer> mView;

        MessageHandler() {
//            mView = new WeakReference<>(view);
        }

        @Override
        public void handleMessage(Message msg) {
//            HgLVideoTrimmer view = mView.get();
            if (mvv == null) {
                return;
            }

//            view.notifyProgressUpdate(true);
            if (mvv.isPlaying()) {
                sendEmptyMessageDelayed(0, 10);
            }
        }
    }


}


/**
 * **
 * 、///////////////////////////////////////下面的代码为测试代码，没用，不用看////////////////////////////////////////////////////
 * 通过键值对存储图片或视频的路径
 * <p>
 * 显示系统图片的视图
 * <p>
 * 定义图片路径的实体
 * <p>
 * 定义一个弹出popupwindow变量名
 * <p>
 * 最外层布局的变量
 * <p>
 * 定义一个TextView的成员变量
 * <p>
 * 定义一个Button的成员变量
 * <p>
 * 记录图片的最大选择
 * <p>
 * 在视频选择中录像的请求码
 * <p>
 * 在图片选择中拍照的请求码
 * <p>
 * 在图片选择点击后请求码
 * <p>
 * 存储视频路径的集合
 * <p>
 * 上传类型
 * Imageview
 * 上传大小
 * <p>
 * 加载下拉框视频列表
 * <p>
 * 添加图片或视频地址
 *
 * @param imageFile
 * <p>
 * //                 * 存储视频路径的集合
 * //
 * 在录像选择中录像
 * @param imageDir
 */

/*



MyVideoView vv;
    ImageView  imgTitle;
    String s;

    private TextView buttonGetStarted;

    private static final int REQUEST_VIDEO_TRIMMER = 0x01;
    private static final int REQUEST_STORAGE_READ_ACCESS_PERMISSION = 101;
    public static final String EXTRA_VIDEO_PATH = "EXTRA_VIDEO_PATH";
    public static final String VIDEO_TOTAL_DURATION = "VIDEO_TOTAL_DURATION";

    */
/**
 * 通过键值对存储图片或视频的路径
 *//*

    private HashMap<String, ImageDir> imageDirsMap = new HashMap<String, ImageDir>();
    */
/**
 * 显示系统图片的视图
 *//*

    MyGridView gvPhotos;
    */
/**
 * 定义图片路径的实体
 *//*

    ImageDir currentDir;
    */
/**
 * 定义一个弹出popupwindow变量名
 *//*

//    ImageFolderPopWindow popDir;
    */
/**
 * 最外层布局的变量
 *//*

    View lyTopBar;
    */
/**
 * 定义一个TextView的成员变量
 *//*

    TextView tvTitle;
    */
/**
 * 定义一个Button的成员变量
 *//*

    Button btnNext;
    int maxPicSize;
    */
/**
 * 记录图片的最大选择
 *//*

    private int maxCount = 1;

    private File cameraFile;
    */
/**
 * 在视频选择中录像的请求码
 *//*

    public static final int REQUEST_CODE_CAMERA = 1000;
    */
/**
 * 在图片选择中拍照的请求码
 *//*

    public static final int REQUEST_CODE_VEDIO = 2000;
    */
/**
 * 在图片选择点击后请求码
 *//*

    public static final int REQUEST_CODE_IMAGE_SWITCHER = 2000;


    */
/**
 * 存储视频路径的集合
 *//*

    private ArrayList<String> selectedFath = new ArrayList<String>();

    View messageLayout;



    String loadType;

    private void initData() {
        //接收从DemoActivity传来的图片选择和录像选择路径
//        selectedFath = getIntent().getStringArrayListExtra("selectedPaths");   //这个是上面的成员变量
        //判断是否存在loadType和sizeLimit，如果有，取出值  （图片没有，视频有）
//        if (getIntent().hasExtra("loadType")) {
//            loadType = Type.valueOf(getIntent().getStringExtra("loadType"));
//        }
*/
/*         *//*
*/
/**
 * 上传类型
 *//*
*/
/*

        loadType = ImageDir.Type.VEDIO.toString();*//*


//        if(getIntent().hasExtra("sizeLimit")){
//            sizeLimit=getIntent().getIntExtra("sizeLimit", 1024);
//        }
     */
/*   *//*
*/
/**Imageview
 * 上传大小
 *//*
*/
/*
        long sizeLimit = 5 * 1024 * 1024;//5m*//*


    }

}






    */
/*private void init() {


        gvPhotos = (MyGridView) messageLayout.findViewById(R.id.gv_photos);
        tvTitle = (TextView) messageLayout.findViewById(R.id.tv_top_bar_title);
        imgTitle = (ImageView) messageLayout.findViewById(R.id.iv_back_topic2);
        btnNext = (Button) messageLayout.findViewById(R.id.btn_next);
        vv = (MyVideoView) messageLayout.findViewById(R.id.vv);
        loadVedioImagesList();

        imgTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
//                startTrimActivity(Uri.parse(s));


                Intent intent = new Intent(getActivity(), TrimmerActivity.class);
                intent.putExtra("chooseVideoFragment",s);

                startActivity(intent);


            }
        });

    }

*//*


//    private void startTrimActivity(Uri uri) {
//        Intent intent = new Intent(getActivity(), TrimmerActivity.class);
//        intent.putExtra(EXTRA_VIDEO_PATH, FileUtils.getPath(getActivity(), uri));
//        intent.putExtra(VIDEO_TOTAL_DURATION, getMediaDuration(uri));
//        startActivity(intent);
//    }

*/
/*    private int  getMediaDuration(Uri uriOfFile)  {
        MediaPlayer mp = MediaPlayer.create(getActivity(),uriOfFile);
        int duration = mp.getDuration();
        return  duration;
    }*//*




   */
/* *//*
*/
/**
 * 加载下拉框视频列表
 *//*
*/
/*
    private void loadVedioImagesList() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                Cursor cursor = getActivity().getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                        new String[]{MediaStore.Video.Media.DATA, MediaStore.Video.Media.MIME_TYPE, MediaStore.Video.Media._ID},
                        null, null,
                        MediaStore.Images.Media.DATE_MODIFIED);
                while (cursor.moveToNext()) {
                    String filePath = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                    String id = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media._ID));
                    File imageFile = new File(filePath);
                    ImageDir dir = addToDir(imageFile);   //添加图片或视频地址
                    //dir.ids.add(id+"");
                    dir.setType(ImageDir.Type.VEDIO);   //这里改成Image类型也不影响
                    if (dir.files.size() > maxPicSize) {
                        maxPicSize = dir.files.size();
                        currentDir = dir;
                    }

                    if (selectedFath.contains(filePath)) {
                        dir.selectedFiles.add(filePath);
                    }
                }

                getActivity().runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        loadVedioImages(currentDir);
                    }
                });
            }
        }).start();
    }


    *//*
*/
/**
 * 添加图片或视频地址
 *
 * @param imageFile
 *//*
*/
/*
    private ImageDir addToDir(File imageFile) {
        ImageDir imageDir;
        File parentDirFile = imageFile.getParentFile();
        String parentFilePath = parentDirFile.getPath();
        if (!imageDirsMap.containsKey(parentFilePath)) {
            imageDir = new ImageDir(parentFilePath);
            imageDir.dirName = parentDirFile.getName();
            imageDirsMap.put(parentFilePath, imageDir);
            imageDir.firstImagePath = imageFile.getPath();
//            Log.i("PhotoSelectorActivity",imageDir.firstImagePath);
            imageDir.addFile(imageFile.toString());
        } else {
            imageDir = imageDirsMap.get(parentFilePath);
            imageDir.addFile(imageFile.toString());
        }

        return imageDir;
    }


    //加载视频
    private void loadVedioImages(final ImageDir imageDir) {
        PhotoSelectorAdapter adapter = new PhotoSelectorAdapter(getActivity(), imageDir);
        gvPhotos.setAdapter(adapter);
        gvPhotos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });


//        BitmapUtils bitmapUtils = new BitmapUtils(this);
//        gvPhotos.setOnScrollListener(new PauseOnScrollListener(bitmapUtils, false, true));
        //视频选择事件    真正点击走的步骤，上面也有个方法不晓得为什么没有走
        adapter.setOnItemCheckdedChangedListener(new PhotoSelectorAdapter.onItemCheckedChangedListener() {

            @Override
            public void onItemCheckChanged(ImageDir imageDir, String path, int position) {
                //判断是否可选，如果选择大于3张，则不能再选了，否则可以选择
//                if (isCheced) {
//                    if (getSelectedPictureCont() >= maxCount) {
//                        Toast.makeText(PhotoSelectorActivity.this, "不能选择超过" + maxCount, Toast.LENGTH_SHORT).show();
//                        chBox.setChecked(false);
//                        imageDir.selectedFiles.remove(path);  //如果已经选择就再次点击就移除
//                    } else {
//                        imageDir.selectedFiles.add(path);    //如果以前没有选择，点击选择
//                    }
//                } else {
//                    imageDir.selectedFiles.remove(path);
//                }
               s = imageDir.getFiles().get(position - 1);
                placevideo(s);//播放视频
*//*



                //用来更新下一步的文字
//                updateNext();
//                Log.i("zll",getSelectedPicture()+"");
//                Intent intent = new Intent();
//                //传入图片选择路径的集合
//                intent.putExtra("selectPaths", getSelectedPicture());
//                //返回成功给DemoActivity界面
//                // setResult(RESULT_OK, intent);
//                // finish();
//                files=new ArrayList<File>();
//
//
//
//                */
/**
 //                 * 存储视频路径的集合
 //                 *//*

////                ArrayList<String> selectedVedioPaths = new ArrayList<String>();
//                ArrayList<String> selectedVedioPaths = intent.getStringArrayListExtra("selectPaths");
//                //将选择的视频路径放入文件中
//                //清空视频文件
//                files.clear();
//                for (int i=0;i<selectedVedioPaths.size();i++){
//                    File fileVedio=new File(selectedVedioPaths.get(i));
//                    files.add(fileVedio);
//                    Log.i("TGA", selectedVedioPaths.get(i));
//                    Log.i("TGA", fileVedio+"");
//                }
                //上传
                //  upload(files);
         */
/*   }

            @Override
            public void onTakePicture(ImageDir imageDir) {
                //在录像选择中录像
                takeVedio(imageDir);
            }

            @Override
            public void onShowPicture(String path) {
                //显示具体的图片
//                showImage(path);
            }
        });
    }

    *//*
*/
/**
 * 在录像选择中录像
 *
 * @param imageDir
 *//*
*/
/*
    public void takeVedio(ImageDir imageDir) {
        cameraFile = new File(imageDir.dirPath, System.currentTimeMillis() + ".mp4");
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE).putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(cameraFile));
        //intent.putExtra(MediaStore.EXTRA_SIZE_LIMIT, sizeLimit);
        //intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);

        startActivityForResult(intent, REQUEST_CODE_CAMERA);
    }

    public void placevideo(String s) {

        //设置视频路径
        vv.setVideoURI(Uri.parse(s));
        //开始播放视频
        vv.start();

    }
*//*



*/
