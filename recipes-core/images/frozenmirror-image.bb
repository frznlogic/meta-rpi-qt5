DESCRIPTION = "Image for creating a small bootable image"

inherit core-image populate_sdk_qt5

IMAGE_FEATURES += "package-management hwcodecs tools-debug"


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
    qtbase \
    qtdeclarative \
    qtdeclarative-qmlplugins \
    qtdeclarative-tools \
"

IMAGE_INSTALL += " \
    frozenmirror \
"

IMAGE_INSTALL += " \
    userland \
    wiringpi \
    rpio \
    rpi-gpio \
    speex \
"

do_rootfs_postprocess_dev() {
    install -Dm0644 ${THISDIR}/${PN}/wired.network \
        ${IMAGE_ROOTFS}/${sysconfdir}/systemd/network/wired.network
}

ROOTFS_POSTPROCESS_COMMAND += "do_rootfs_postprocess_dev; "

