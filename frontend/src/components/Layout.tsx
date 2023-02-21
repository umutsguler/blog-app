import Navbar from "../components/Navbar";
import { ReactNode } from "react";

type LayoutProps = { children: ReactNode };
const Layout = ({ children }: LayoutProps) => {
  return (
    <div>
      <Navbar />
      {children}
    </div>
  );
};

export default Layout;