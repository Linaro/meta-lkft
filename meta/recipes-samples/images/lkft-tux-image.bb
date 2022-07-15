SUMMARY = "Basic console image for LKFT"

IMAGE_FEATURES += "debug-tweaks hwcodecs"

# Add 512 MB of extra space on image.
IMAGE_ROOTFS_EXTRA_SPACE = "524288"

LICENSE = "MIT"

inherit core-image extrausers

CORE_IMAGE_BASE_INSTALL += " \
    kernel-modules \
    libgpiod \
    libgpiod-tools \
    ltp \
    "

EXTRA_USERS_PARAMS = "\
useradd -p '' linaro; \
"
