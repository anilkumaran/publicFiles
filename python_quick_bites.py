from datetime import datetime

out_file_path = str(datetime.now())+ ".txt"

def print_n_write_to_file(msg):
    msg = str(datetime.now()) + ' ' + msg
    print(msg)
    with open(out_file_path, 'a') as out_file:
        out_file.write(msg + '\n')

# Usage
def add(a, b):
    print_n_write_to_file(f'a: {a}')
    print_n_write_to_file(f'b: {b}')
    return a + b
