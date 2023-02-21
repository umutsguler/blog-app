import "@/styles/globals.css";
import type { AppProps } from "next/app";
import { Provider } from "react-redux";
import { store } from "@/src/redux/store";
import Layout from "@/src/components/Layout";

export default function App({ Component, pageProps }: AppProps) {
  return <Provider store={store}>
    <Layout>
      <Component {...pageProps} />
    </Layout>
  </Provider>;
}


