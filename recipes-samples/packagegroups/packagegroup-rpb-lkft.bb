SUMMARY = "Organize packages to avoid duplication across all images"

inherit packagegroup

# contains basic dependencies for LKFT
RDEPENDS_packagegroup-rpb-lkft = "\
    android-kernel-tests \
    cpupower \
    ${@bb.utils.contains_any("TUNE_ARCH", "arm mips", "", "fwts", d)} \
    git \
    grep \
    haveged \
    ${@bb.utils.contains("TUNE_ARCH", "mips", "", "\
      igt-gpu-tools \
      igt-gpu-tools-benchmarks \
      igt-gpu-tools-tests \
    ", d)} \
    jq \
    kernel-selftests \
    kselftests-mainline \
    kselftests-next \
    libgpiod \
    libgpiod-tools \
    ${@bb.utils.contains("TUNE_ARCH", "mips", "", "libhugetlbfs-tests", d)} \
    net-snmp \
    ${@bb.utils.contains("TUNE_ARCH", "arm", "", "numactl", d)} \
    ${@bb.utils.contains_any("TUNE_ARCH", "arm i686 mips", "", "packetdrill", d)} \
    perf \
    perf-tests \
    qemu \
    s-suite \
    tzdata \
    vdsotest \
    xz \
    "
