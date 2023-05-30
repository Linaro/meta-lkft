SUMMARY = "Organize packages to avoid duplication across all images"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-lkft-tools \
    packagegroup-lkft-tools-basics \
    packagegroup-lkft-tools-python3 \
    "

RDEPENDS:packagegroup-lkft-tools = "\
    packagegroup-core-buildessential \
    packagegroup-lkft-tools-basics \
    packagegroup-lkft-tools-python3 \
    "

SUMMARY:packagegroup-lkft-tools = "Basic tools and libraries for LKFT"
RDEPENDS:packagegroup-lkft-tools-basics = "\
    btrfs-tools \
    coreutils \
    dosfstools \
    e2fsprogs \
    e2fsprogs-mke2fs \
    git \
    grep \
    haveged \
    jq \
    ${@bb.utils.contains("TUNE_ARCH", "arm", "", "numactl", d)} \
    net-snmp \
    ntfs-3g \
    ntfsprogs \
    os-release \
    qemu \
    sed \
    socat \
    tzdata \
    usbutils \
    xfsprogs-mkfs \
    xz \
    "

SUMMARY:packagegroup-lkft-tools-python3 = "Python3 support for running tests"
RDEPENDS:packagegroup-lkft-tools-python3 = "\
    python3 \
    python3-misc \
    python3-modules \
    python3-scapy \
    "
