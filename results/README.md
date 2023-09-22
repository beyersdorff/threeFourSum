# Efficient 3SUM and 4SUM Algorithm Implementations Benchmark

This project aims to establish an experimental environment for benchmarking diverse 3SUM algorithm implementations in terms of processing time. It also extends the scope to tackle the 4SUM problem. The experiments were conducted using Python and implemented within a Java Gradle project, with comprehensive testing facilitated by JUnit.

See report: [3SUM & 4SUM Report](https://github.com/beyersdorff/threeFourSum/blob/main/report.pdf)

## Requirements

* Java 17
* Python 3


### Buil project
``` build project
~threefoursum $ ./gradlew build
```

### Run tests
``` run tests
~threefoursum $ ./gradlew test
```

### Run experiments
``` run experiments
$ python3 experiments.py
```

### Run postprocess
``` run postprocess
$ python3 postprocess.py
```