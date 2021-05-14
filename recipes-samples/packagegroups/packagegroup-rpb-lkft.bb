SUMMARY = "Organize packages to avoid duplication across all images"

inherit packagegroup

# contains basic dependencies for LKFT
RDEPENDS_packagegroup-rpb-lkft = "\
    android-kernel-tests \
    ${@bb.utils.contains("TUNE_ARCH", "arm", "", "fwts", d)} \
    git \
    grep \
    haveged \
    igt-gpu-tools \
    igt-gpu-tools-benchmarks \
    igt-gpu-tools-tests \
    jq \
    kernel-selftests \
    kselftests-mainline \
    kselftests-next \
    libgpiod \
    libsan \
    libubsan \
    net-snmp \
    ${@bb.utils.contains("TUNE_ARCH", "arm", "", "numactl", d)} \
    ${@bb.utils.contains_any("TUNE_ARCH", "arm i686", "", "packetdrill", d)} \
    perf \
    perf-tests \
    qemu \
    tzdata \
    xz \
    "
