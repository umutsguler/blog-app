import React from "react";
import Image from "next/image";
import { TextInput, Button, PasswordInput } from "@mantine/core";
import Head from "next/head";
import { useAppSelector, useAppDispatch } from "@/src/redux/hooks";
import { testReducer } from "@/src/redux/authSlice";

const Login = () => {

  const [form, setForm] = React.useState({ email: "", password: "" });
  const test = useAppSelector((state) => state.authReducer.value);
  const dispatch = useAppDispatch();

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleLogin = () => {
    dispatch(testReducer(form.email));
  };

  return (
    <div>
      <Head>
        <title>Login</title>
      </Head>
      <section className="h-screen">
        <div className="px-6 h-full text-gray-800">
          <div
            className="flex xl:justify-center lg:justify-between justify-center items-center flex-wrap h-full g-6"
          >
            <div
              className="grow-0 shrink-1 md:shrink-0 basis-auto xl:w-6/12 lg:w-6/12 md:w-9/12 mb-12 md:mb-0"
            >
              <Image
                src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                className="w-full"
                alt="Sample image"
                width={500}
                height={500}
              />
            </div>
            <div className="xl:ml-20 xl:w-5/12 lg:w-5/12 md:w-8/12 mb-12 md:mb-0">
              <form>
                <div className="mb-6">
                  <TextInput onChange={(e: React.FormEvent<HTMLInputElement>) => handleChange(e as any)} name={"email"}
                    label="Email" className={"w-full"} />
                </div>
                <div className="mb-6">
                  <PasswordInput onChange={(e: React.FormEvent<HTMLInputElement>) => handleChange(e as any)}
                    name={"password"} label="Password" />
                </div>
                <div className="text-center lg:text-left">
                  <Button variant={"outline"} onClick={(e) => handleLogin()}>
                    Login
                  </Button>
                  <p className="text-sm font-medium mt-2 pt-1 mb-0">
                    Dont have an account?
                    <a href="#"
                      className="text-red-600 hover:text-red-700 focus:text-red-700 transition duration-200 ease-in-out ml-1">Register</a>
                  </p>
                </div>
              </form>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
};

export default Login;