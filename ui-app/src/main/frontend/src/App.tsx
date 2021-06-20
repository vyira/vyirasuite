import React from "react";
import "./App.scss";
import WelcomePage from "./pages/WelcomePage";
import Admin from "./pages/Admin";
import { useAppDispatch, useAppSelector } from "./redux/hooks";
import { PrimaryButton, Stack } from "@fluentui/react";
import { login, logout } from "./redux/slice/sessionSlice";

function App() {
  const sessionState = useAppSelector((state) => state.session);
  const dispatch = useAppDispatch();

  const loginLogout = () => {
    console.log(sessionState.isLogin);
    if (!sessionState.isLogin) {
      dispatch(
        login({ fullName: "Awatansa Vishwakarma", username: "awatansa" })
      );
    } else {
      dispatch(logout());
    }
  };

  return (
    <div className="App">
      <Stack tokens={{ childrenGap: 20 }}>
        {sessionState.isLogin ? <Admin /> : <WelcomePage />}
        <PrimaryButton
          text={sessionState.isLogin ? "Logout" : "Login"}
          onClick={loginLogout}
        />
      </Stack>
    </div>
  );
}

export default App;
