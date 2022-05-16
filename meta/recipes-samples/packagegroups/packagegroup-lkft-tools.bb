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
    cpupower \
    git \
    grep \
    haveged \
    jq \
    libgpiod \
    libgpiod-tools \
    ${@bb.utils.contains("TUNE_ARCH", "arm", "", "numactl", d)} \
    net-snmp \
    perf \
    qemu \
    tzdata \
    usbutils \
    xz \
    "

SUMMARY:packagegroup-lkft-tools-python3 = "Python3 support for running tests"
RDEPENDS:packagegroup-lkft-tools-python3 = "\
    python3 \
    python3-misc \
    python3-modules \
    "
