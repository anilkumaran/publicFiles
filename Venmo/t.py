


def log(fn):
    def wrapper(*args, **kwargs):
        print('Called', fn.__name__)
        return fn(*args, **kwargs)
    return wrapper



def log(fn):
    def wrapper(*args, **kwargs):
    return wrapper
def add(a,b):
    return a + b





def counter():
    for i in range(5):
        yield i


print(list(counter())))