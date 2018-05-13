# prueba_almundo
El diseño de la solucion se baso la entidad empleado y las de Operador, Supervisor y director que heredan de empleado

![alt text](https://github.com/ramirovargas/prueba_almundo/blob/master/src/main/resources/dise%C3%B1o.jpg)

El empleado tiene un atributo libre para saber que empleado esta libre
El metodo dispatchcall busca repartir las tareas dependiendo el atributo libre del empleado

Para los hilo de la aplicacion se utilizo la libreria thread y execution service para crear 10 pool de trabajo

-----Extra------

Para resolver el problema de que no haya empleados atendiendo pensaria en implementar un modelo de colas de espera
para asi tener en espera la llamada del usuario y al final puedan atenderlo

Gracias
