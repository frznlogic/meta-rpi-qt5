DESCRIPTION = "Image for creating a small bootable image"

inherit core-image

include rpi-hwup-image.bb

IMAGE_INSTALL += " \
    bash \
    less \
    bzip2 \
    gzip \
    coreutils \
    procps \
    psplash \
    openssh \
"

IMAGE_INSTALL += " \
    wayland \
    weston \
    weston-examples \
    speex \
"


IMAGE_INSTALL += " \
    qtbase \
    qtdeclarative \
    qtdeclarative-qmlplugins \
    qtdeclarative-tools \
    qtwebkit \
"

IMAGE_INSTALL += " \
    qmlmirror \
"

IMAGE_INSTALL += " \
    userland \
    wiringpi \
    rpio \
    rpi-gpio \
"

# helpers (dev)
IMAGE_FEATURES += "package-management hwcodecs x11"

TOOLCHAIN_HOST_TASK += "nativesdk-cmake"

# Add "/usr/lib/cmake" to the PATH variable so that CMake can find the *Config.cmake" when FIND_PACKAGE() is called from a CMake makefile
toolchain_create_sdk_env_script_append() {
        echo 'export PATH=$PATH:$SDKTARGETSYSROOT/usr/lib/cmake' >> $script
}

do_rootfs_postprocess_dev() {
    install -Dm0644 ${THISDIR}/${PN}/wired.network \
        ${IMAGE_ROOTFS}/${sysconfdir}/systemd/network/wired.network
}

ROOTFS_POSTPROCESS_COMMAND += "do_rootfs_postprocess_dev; "

# No need for too much space right now, but some extra is always nice. 
IMAGE_ROOTFS_SIZE ?= "1000000"

