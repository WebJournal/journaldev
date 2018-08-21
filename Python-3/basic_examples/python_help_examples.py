def add(x, y):
    """
    This function adds the given integer arguments
    :param x: integer
    :param y: integer
    :return: integer
    """
    return x + y


class Employee:
    """
    Employee class, mapped to "employee" table in Database
    """
    id = 0
    name = ''

    def __init__(self, i, n):
        """
        Employee object constructor
        :param i: integer, must be positive
        :param n: string
        """
        self.id = i
        self.name = n

