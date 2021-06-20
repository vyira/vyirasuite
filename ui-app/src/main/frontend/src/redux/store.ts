import { configureStore } from "@reduxjs/toolkit";
import sessionReducer from "./slice/sessionSlice";
import uiReducer from "redux/slice/uiSlice";

const store = configureStore({
  reducer: {
    session: sessionReducer,
    ui: uiReducer,
  },
});

export default store;
export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
