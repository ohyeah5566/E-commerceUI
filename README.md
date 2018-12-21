# E-commerceUI
[APK下載](https://drive.google.com/file/d/1SB2YXrTJb18f0tio3uy1N4v_2JMlBI0H/view?usp=sharing)<br />
之前去面試被說Layout UI的經驗不足<br />
只好先花點時間寫一個模仿電商平台的APP練習一下Layout<br />
以下是目前的成果圖，目前雖然只有完成了一頁，不過已經練習到非常多東西了<br />
主要練習到了RecyclerView的應用，和刻了不少的CLayout<br />

# 12/21 完成了會員中心的頁面 (參考蝦皮的我的)
<img src="https://github.com/ohyeah5566/E-commerceUI/blob/master/ReadmeFile/readme_profile.png" alt="demogif" height="320" width="180">
  
# 12/14 完成了商城的頁面 (參考蝦皮的蝦拚)
實作了以下功能<br />
<img src="https://github.com/ohyeah5566/E-commerceUI/blob/master/ReadmeFile/Demo%20gif.gif" alt="demogif" height="320" width="180">

1. 圖片輪播  使用第三方套件Banner去實現。
<img src="https://github.com/ohyeah5566/E-commerceUI/blob/master/ReadmeFile/banner.gif" alt="BannerGif" height="100" width="240">

2. 可以左右滑動的商品限時特賣
<img src="https://github.com/ohyeah5566/E-commerceUI/blob/master/ReadmeFile/hotsale.gif" alt="BannerGif" height="100" width="240">

3. RecyclerView的item，滑到底載入更多的item
RecyclerView新增OnScrollListener的類別，監聽直向的滾動是否到底

4. RecyclerView的Title，往下滑會讓Title掛在Toolbar下面
RecyclerView新增一個ItemDecoration，複寫onDrawOver的動作

5. 使用Smallest width(最小寬度) 去調整不同尺寸(768p,1080p,2k)的手機Layout。<br />
參考這篇https://juejin.im/post/5ae9cc3a5188253dc612842b 裏頭的smallestWidth适配去實現
![image](https://github.com/ohyeah5566/E-commerceUI/blob/master/ReadmeFile/size.png)


使用的第三方套件<br />
[Glide](https://github.com/bumptech/glide)<br />
[Butter](http://jakewharton.github.io/butterknife/)<br />
[Banner](https://github.com/youth5201314/banner)
