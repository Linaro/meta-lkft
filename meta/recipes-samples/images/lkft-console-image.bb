SUMMARY = "Basic console image for LKFT"

IMAGE_FEATURES += "debug-tweaks hwcodecs package-management splash ssh-server-openssh tools-debug"

# Add 1 GB of extra space on image.
IMAGE_ROOTFS_EXTRA_SPACE = "1048576"

# Add 512 MB on X15; more than that might exceed the
# userdata partition capacity.
IMAGE_ROOTFS_EXTRA_SPACE_am57xx-evm = "524288"

LICENSE = "MIT"

inherit core-image extrausers

CORE_IMAGE_BASE_INSTALL += " \
    kernel-modules \
    packagegroup-lkft-testsuites \
    packagegroup-lkft-tools \
    "

EXTRA_USERS_PARAMS = "\
useradd -p '' linaro; \
"
