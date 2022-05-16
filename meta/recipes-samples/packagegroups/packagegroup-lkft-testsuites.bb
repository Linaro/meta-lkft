SUMMARY = "Organize packages to avoid duplication across all images"

inherit packagegroup

SUMMARY_RDEPENDS_packagegroup-lkft-testsuites = "Test suites used by LKFT"
RDEPENDS_packagegroup-lkft-testsuites = "\
    ${@bb.utils.contains_any("TUNE_ARCH", "arm", "", "fwts", d)} \
    ${@bb.utils.contains("TUNE_ARCH", "mips", "", "\
      igt-gpu-tools \
      igt-gpu-tools-benchmarks \
      igt-gpu-tools-tests \
    ", d)} \
    kernel-selftests \
    kselftests-mainline \
    kselftests-next \
    ltp \
    perf-tests \
    s-suite \
    vdsotest \
    "
