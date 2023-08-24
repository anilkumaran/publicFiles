import pymysql

 

class DB_Handler:

    def __init__(self):

        self.con=None

        self.__connect(True)

 

    def __connect(self, force=False):

        self.con = pymysql.connect(host='172.16.1.210',

                                    user='bbenjaram',

                                    password='Sid$osi#123',

                                    database='bbenjaram',

                                    cursorclass=pymysql.cursors.DictCursor)

       

    def run_query(self,stmt,values=()):

        result = None

        with self.con:

            with self.con.cursor() as cursor:

                # selecting record or records

                cursor.execute(stmt,values)

                result = cursor.fetchall()

        return result

           

    def run_dml(self,stmt,values=()):

        with self.con:

            with self.con.cursor() as cursor:

                # selecting record or records

                cursor.execute(stmt,values)

            self.con.commit()

            print("Operation successful")

           

    def run_ddl(self,stmt):

        with self.con:

            with self.con.cursor() as cursor:

                # selecting record or records

                cursor.execute(stmt)

            self.con.commit()

            print("Operation done")
