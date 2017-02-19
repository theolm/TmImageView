#TmImageView
A simple android widget to use imageview as a button with animations pass through xml.

#Demo
![demo](https://github.com/theolm/TmImageView/raw/master/demo.gif)

#Installation
Import it on your **build.gradle** module.
```
repositories {
    maven { url  "http://theomota.bintray.com/maven" }
}

dependencies {
    compile 'com.theomota:tmimageview:0.1'
}
```

#Documentation
To use the widget, you only need to add this to your xml:
```
<com.theomota.tmimageview.TmImageView
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:layout_margin="20dp"
            android:src="@drawable/android_robot"
            android:layout_centerInParent="true"
            app:animation="@anim/scale_up"
            />
```

You can provide the animation with:
```
app:animation="@anim/scale_up"
```
it need to be a reference to a XML file with a animation in it.
if you don't provide any animation the default is a scale up animation.

The lib comes with three animations:
```
app:animation="@anim/scale_up"
```
```
app:animation="@anim/scale_down"
```
```
app:animation="@anim/rotate"
```

#License

 Copyright 2016 Theodoro L. Mota

 Licensed under the Apache License, Version 2.0 (the 	"License");
 you may not use this file except in compliance with 	the License.
 You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in 	writing, software
 distributed under the License is distributed on an 	"AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 	either express or implied.
 See the License for the specific language governing 	permissions and
 limitations under the License.
