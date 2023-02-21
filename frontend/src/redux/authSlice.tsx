import { createSlice } from "@reduxjs/toolkit";
import type { PayloadAction } from "@reduxjs/toolkit";


interface AuthState {
  value: string;
}


const initialState: AuthState = {
  value: "test"
};

export const authSlice = createSlice({
  name: "test",
  initialState,
  reducers: {
    testReducer: (state, action: PayloadAction<string>) => {
      state.value = action.payload;
    }
  }
});

export const {testReducer } = authSlice.actions;
export default authSlice.reducer;