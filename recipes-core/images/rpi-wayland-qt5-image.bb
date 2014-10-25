DESCRIPTION = "Image for creating a small bootable image"

inherit core-image

IMAGE_INSTALL += "weston wayland qtbase qtwayland"

# helpers (dev)
IMAGE_FEATURES += "package-management hwcodecs"

TOOLCHAIN_HOST_TASK += "nativesdk-cmake"

# Add "/usr/lib/cmake" to the PATH variable so that CMake can find the *Config.cmake" when FIND_PACKAGE() is called from a CMake makefile
toolchain_create_sdk_env_script_append() {
        echo 'export PATH=$PATH:$SDKTARGETSYSROOT/usr/lib/cmake' >> $script
}

# No need for too much space right now, but some extra is always nice. 
IMAGE_ROOTFS_SIZE ?= "1000000"

IMAGE_FSTYPES ?= "ext3 sdcard"

