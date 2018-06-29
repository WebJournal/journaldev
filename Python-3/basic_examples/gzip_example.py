import gzip
import io
import os
import itertools

output_file_name = 'jd_example.txt.gz'
file_mode = 'wb'

with gzip.open(output_file_name, file_mode) as output:
    with io.TextIOWrapper(output, encoding='utf-8') as enc:
        enc.writelines(
            itertools.repeat('JournalDev, same line again and again!.\n', 10)
        )

os.system('gzcat jd_example.txt.gz')