import { createSlice, PayloadAction } from "@reduxjs/toolkit";

interface ILogin {
  username: string;
  isLogin: boolean;
  fullName?: string;
}

const initialState: ILogin = {
  fullName: "",
  isLogin: false,
  username: "",
};

const sessionSlice = createSlice({
  name: "session",
  initialState,
  reducers: {
    login(
      state,
      action: PayloadAction<{ fullName: string; username: string }>
    ) {
      state.isLogin = true;
      state.fullName = action.payload.fullName;
      state.username = action.payload.username;
    },
    logout(state) {
      state.isLogin = false;
      state.fullName = "";
      state.username = "";
    },
  },
});

export const { login, logout } = sessionSlice.actions;
export default sessionSlice.reducer;
