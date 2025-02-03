<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <link rel="stylesheet" href="./dist/styles2.css">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
        }

        .input-div:before,
        .input-div:after {
            content: '';
            position: absolute;
            bottom: -2px;
            height: 2px;
            transition: .4s;
            background-color: #60a5fa;
            width: 0%;
        }

        .input-div:before {
            right: 50%;
        }

        .input-div:after {
            left: 50%;
        }

        .input-div.focus:before,
        .input-div.focus:after {
            width: 50%;
        }

        .input-div.focus .h5 {
            top: -5px;
            font-size: 15px;
        }

        .input-div.focus .i i {
            color: #60a5fa;
        }
    </style>
</head>

<body class="overflow-hidden">
    <!--<img class="fixed bottom-0 left-0 h-full -z-10" src="img/wave.png" alt="Wave">-->
    <div class="container mx-auto min-h-screen grid grid-cols-1 md:grid-cols-2 gap-7 px-8">
        <div class="flex justify-center items-center">
            <img src="img/bg.svg" class="hidden md:block w-96" alt="Background Image">
        </div>
        <div class="flex justify-center md:justify-start items-center text-center">
            <form action="index.html" class="w-72 md:w-96" method="post" action="controlUsu">
                <input type="hidden" name="opc" value="6">
                <img src="img/avatar.svg" class="h-24 mx-auto" alt="Avatar">
                <h2 class="text-4xl font-bold text-gray-800 my-4 uppercase">Registrate</h2>
                <div class="input-div relative grid grid-cols-[7%_93%] mb-6 border-b-2 border-gray-300">
                    <div class="i flex justify-center items-center text-gray-400">
                        <i class="fas fa-user"></i>
                    </div>
                    <div class="relative">
                        <h5
                            class="h5 absolute left-2 top-1/2 transform -translate-y-1/2 text-gray-500 text-lg transition-all pointer-events-none">
                            Nombre</h5>
                        <input type="text"
                               class="w-full h-full border-none outline-none bg-transparent p-2 text-lg text-gray-700 focus:ring-0" name="nom">
                    </div>
                </div>
                <div class="input-div relative grid grid-cols-[7%_93%] mb-6 border-b-2 border-gray-300">
                    <div class="i flex justify-center items-center text-gray-400">
                        <i class="far fa-user"></i>
                    </div>
                    <div class="relative">
                        <h5
                            class="h5 absolute left-2 top-1/2 transform -translate-y-1/2 text-gray-500 text-lg transition-all pointer-events-none">
                            Apellido</h5>
                        <input type="text"
                               class="w-full h-full border-none outline-none bg-transparent p-2 text-lg text-gray-700 focus:ring-0" name="ape">
                    </div>
                </div>
                <div class="input-div relative grid grid-cols-[7%_93%] mb-6 border-b-2 border-gray-300">
                    <div class="i flex justify-center items-center text-gray-400">
                        <i class="fas fa-id-card"></i>
                    </div>
                    <div class="relative">
                        <h5
                            class="h5 absolute left-2 top-1/2 transform -translate-y-1/2 text-gray-500 text-lg transition-all pointer-events-none">
                            Dni</h5>
                        <input type="text"
                               class="w-full h-full border-none outline-none bg-transparent p-2 text-lg text-gray-700 focus:ring-0" name="dni">
                    </div>
                </div>
                <div class="input-div relative grid grid-cols-[7%_93%] mb-6 border-b-2 border-gray-300">
                    <div class="i flex justify-center items-center text-gray-400">
                        <i class="fas fa-envelope"></i>
                    </div>
                    <div class="relative">
                        <h5
                            class="h5 absolute left-2 top-1/2 transform -translate-y-1/2 text-gray-500 text-lg transition-all pointer-events-none">
                            Correo</h5>
                        <input type="text"
                               class="w-full h-full border-none outline-none bg-transparent p-2 text-lg text-gray-700 focus:ring-0" name="correo">
                    </div>
                </div>
                <div class="input-div relative grid grid-cols-[7%_93%] mb-1 border-b-2 border-gray-300">
                    <div class="i flex justify-center items-center text-gray-400">
                        <i class="fas fa-lock"></i>
                    </div>
                    <div class="relative">
                        <h5
                            class="h5 absolute left-2 top-1/2 transform -translate-y-1/2 text-gray-500 text-lg transition-all pointer-events-none">
                            Contrase�a</h5>
                        <input type="password"
                               class="w-full h-full border-none outline-none bg-transparent p-2 text-lg text-gray-700 focus:ring-0" name="contra">
                    </div>
                </div>
                <a href="login.jsp" class="block text-right text-gray-500 text-sm hover:text-blue-500 transition-colors">Ya tienes cuenta? Inicia sesi�n</a>
                <input type="submit"
                    class="w-full h-12 rounded-full bg-gradient-to-r from-blue-400 via-blue-500 to-blue-400 text-white text-lg uppercase mt-4 cursor-pointer duration-500 bg-size-200 bg-pos-100 hover:bg-pos-0"
                    value="Login">
            </form>
        </div>
    </div>
    <script>
        document.querySelectorAll('.input-div').forEach(div => {
            div.querySelector('input').addEventListener('focus', () => {
                div.classList.add('focus');
            });
            div.querySelector('input').addEventListener('blur', () => {
                if (!div.querySelector('input').value) {
                    div.classList.remove('focus');
                }
            });
        });
    </script>
</body>

</html>
