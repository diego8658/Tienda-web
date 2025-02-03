<%@page import="modelo.GProdPre"%>
<%@page import="DAO.prodDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <script src="js/Chart.min.js"></script>
  <style>
    .container {
      width: 70%;
      margin: 15px auto;
    }
    body {
      text-align: center;
      color: green;
    }
    h2 {
      text-align: center;
      font-family: "Verdana", sans-serif;
      font-size: 30px;
    }
  </style>
  <!--Se crea un grafico consumiendo Chart.min.js ingresando los datos traidos por LisProdPre() de prodDao rellenandolos en el grafico-->
  <body>
      <%
          prodDao  obj=new prodDao();
         String label="",data="";
         String tipo=request.getParameter("tipo");
         for(GProdPre x:obj.LisProdPre()){
         label =label+"'"+x.getNombre()+"',";
         data=data+x.getPrecio()+",";
         }
         if(obj.LisProdPre().size()>0){
         label=label.substring(0,label.length()-1);
         data=data.substring(0,data.length()-1);
          }
         String color;
         if(tipo.equals("bar")|| tipo.equals("line")){
           color="'rgba(153,205,1,0.6)'";
          }else{
          color="['rgba(153,205,1,0.6)','lightblue','red','orange','peru','green','blue']";
          }
      %>
    <div class="container">
      <h2>Grafico de Precio de Productos</h2>
      <div>
        <canvas id="myChart"></canvas>
      </div>
    </div>
  </body>
  <script>
    var ctx = document.getElementById("myChart").getContext("2d");
    var myChart = new Chart(ctx, {
      type: "<%=tipo%>",
      data: {
        labels: [<%=label%>],
        datasets: [
          {
            label: "precio",
            data: [<%=data%>],
            backgroundColor: <%=color%>,
          },
        ],
      },
    });
  </script>
</html>
