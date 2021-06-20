import { createSlice } from "@reduxjs/toolkit";

const initialState: any = {};

const uiSlice = createSlice({
  name: "ui",
  initialState,
  reducers: {},
});

const uiReducer = uiSlice.reducer;

export default uiReducer;
