DEPENDS += "\
    xserver-xorg \
    userland \
"
#QMAKE_LIBS_EGL += "/home/oan/Projects/rpi/test/build/tmp-eglibc/sysroots/raspberrypi/usr/lib/libGLESv2.so"

PACKAGECONFIG += "\
    release \
    dbus \
    udev \
    evdev \
    widgets \
    openssl \
    icu \
    gstreamer \
    eglfs \
    ${PACKAGECONFIG_GL} \
    ${PACKAGECONFIG_FB} \
    ${PACKAGECONFIG_X11} \
    ${PACKAGECONFIG_FONTS} \
    ${PACKAGECONFIG_SYSTEM} \
    ${PACKAGECONFIG_MULTIMEDIA} \
    ${PACKAGECONFIG_DISTRO} \
    accessibility \
"

QT_CONFIG_FLAGS += " \
    -release -device-option CROSS_COMPILE=$PATH_TO_SYSROOT_DIR/x86_64-linux/usr/bin/arm-poky-linux-gnueabi/arm-poky-linux-gnueabi- \
    -I$PATH_TO_SYSROOT_DIR/raspberrypi/usr/include/interface/vcos/pthreads \
" 
