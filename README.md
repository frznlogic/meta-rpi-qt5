meta-rpi-qt5
============

This is a yocto meta layer containing some minor adaptations and build 
instructions to generate a raspberry pi 1/2 image which contains Qt5.4. 


Images
------

qmlmirror-image.bb - This image will contain everything needed for a magic
mirror interface on a screen. For more information, search the internet for
Raspberry pi magic mirror. 


Build instructions
------------------

For build instructions into an image, look at
https://github.com/frznlogic/rpi-wayland-qt5


Integration instructions
------------------------
To integrate this with an already existing yocto build, git clone the 
repository into a suitable place, and add meta-rpi-qt5 directory to your
local/bblayers.conf. 

If necessary adapt your meta layer priority in meta-rpi-qt5/conf/layer.conf.


