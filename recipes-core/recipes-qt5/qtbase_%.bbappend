PACKAGECONFIG_append = " eglfs"

QMAKE_LIBS_EGL += "/home/oan/Projects/rpi/test/build/tmp-eglibc/sysroots/raspberrypi/usr/lib/libGLESv2.so"

QT_CONFIG_FLAGS += " \
    -device-option CROSS_COMPILE=$PATH_TO_SYSROOT_DIR/x86_64-linux/usr/bin/arm-poky-linux-gnueabi/arm-poky-linux-gnueabi- \
    -I$PATH_TO_SYSROOT_DIR/raspberrypi/usr/include/interface/vcos/pthreads \
" 
