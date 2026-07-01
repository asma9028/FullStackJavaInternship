import {createSlice} from '@reduxjs/toolkit'

const cartSlice = createSlice({
    name : 'cart',
    initialState : {
        items : [],
    },
    reducers : {
        addItem : (state,action)=>{
            const existing = state.items.find((item)=>item.id === action.payload.id);
            if(existing){
                existing.qty += 1;
            }
            else{
                state.items = state.items.push({...action.payload,qty:1});
            }
        },
        removeItem : (state,action)=>{
            const existing = state.items.find((item)=>item.id === action.payload.id);
             if(existing){
                if(existing.qty === 1){
                    state.items = state.items.filter((item)=>item.id!==action.payload)
                }
                else{
                    existing.qty -= 1;
                }
            }
        }
    }
})