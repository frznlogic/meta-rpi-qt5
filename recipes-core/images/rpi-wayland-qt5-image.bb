DESCRIPTION = "Image for creating a small bootable image"

inherit core-image

include rpi-hwup-image.bb

IMAGE_INSTALL += "userland wayland qtbase"

IMAGE_INSTALL += "bash"
IMAGE_INSTALL += "coreutils"
IMAGE_INSTALL += "procps"
IMAGE_INSTALL += "psplash"
IMAGE_INSTALL += "python-django"
IMAGE_INSTALL += "userland"
IMAGE_INSTALL += "wiringpi"
IMAGE_INSTALL += "rpio"
IMAGE_INSTALL += "rpi-gpio"
IMAGE_INSTALL += "qtwebkit"

# helpers (dev)
IMAGE_FEATURES += "package-management hwcodecs x11"

TOOLCHAIN_HOST_TASK += "nativesdk-cmake"

# Add "/usr/lib/cmake" to the PATH variable so that CMake can find the *Config.cmake" when FIND_PACKAGE() is called from a CMake makefile
toolchain_create_sdk_env_script_append() {
        echo 'export PATH=$PATH:$SDKTARGETSYSROOT/usr/lib/cmake' >> $script
}

# No need for too much space right now, but some extra is always nice. 
IMAGE_ROOTFS_SIZE ?= "1000000"

IMAGE_FSTYPES ?= "ext3 sdcard"

