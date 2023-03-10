
import { useEffect, useState } from 'react';
import './App.css';
import Menu from './Menu';
import {httpPost,httpPostwithToken,httpGet} from './HttpConfig';
import { useParams } from "react-router-dom";
import {CartContextValue} from './ContextProvider';



export default function Product() {
	const params = useParams();
	const [product,setProduct] = useState([]);
	const [cartData,dispatch] = CartContextValue()
	useEffect(()=>{
		//TODO check user login
		localStorage.getItem("isLoggedIn")? getCartApi():test()
	},[])
	const getProductsById = (id)=>{
		
		httpGet("product/getProductsById/",id)
		.then((res)=>{
			res.json().then(response=>{
				
				if(res.ok){
					if(id == response.id){
						setProduct(response)
					}else{
						alert("1No product found..");	
					}
				}else{
					setProduct([])
					alert("No product found..");
				}
			})
		},error=>{
			alert(error.message);
		}
		)
	}
	
	useEffect(()=>{
		getProductsById(params.id);
	},[])

	const test = ()=>{}

	const getCartApi = ()=>{		
		httpPostwithToken("addtocart/getCartsByUserId",{})
		.then((res)=>{				
			res.json() .then(data=>{
				if(res.ok){
					dispatch({
						"type":"add_cart",
						"data":data
					})
					//alert("Successfully added..")
				}else{
					alert(data.message)
				}
			})
		},error=>{
			alert(error.message);
		}
		)
	}
	const addCartApi=(productObj)=>{
		let obj = {
			"productId":productObj.id,			
			"qty":"1",
			"price":productObj.price
			
		}
		httpPostwithToken("addtocart/addProduct",obj)
		.then((res)=>{		
			res.json() .then(data=>{
				if(res.ok){
					dispatch({
						"type":"add_cart",
						"data":data
					})
					alert("Successfully added..")
				}else{
					alert(data.message)
				}
			})     
		}).catch(function(res){
			console.log("Error ",res);
			//alert(error.message);
		}
		)
	}
	
    return (
        <div class="single">
		<div class="container">
			<div class="col-md-4 single-left">
				<div class="flexslider">
					<ul class="slides">
						<li data-thumb="images/a.jpg">
							<div class="thumb-image"> <img src={"../assets/images/"+product.img} data-imagezoom="true" class="img-responsive" alt=""/> </div>
						</li>
						
					</ul>
                    </div>
                    </div>
               

        <div class="col-md-8 single-right">
				<h3>{product.name}</h3>
				<div class="rating1">
					<span class="starRating">
						<input id="rating5" type="radio" name="rating" value="5"/>
						<label for="rating5">5</label>
						<input id="rating4" type="radio" name="rating" value="4"/>
						<label for="rating4">4</label>
						<input id="rating3" type="radio" name="rating" value="3" checked/>
						<label for="rating3">3</label>
						<input id="rating2" type="radio" name="rating" value="2"/>
						<label for="rating2">2</label>
						<input id="rating1" type="radio" name="rating" value="1"/>
						<label for="rating1">1</label>
					</span>
				</div>
				<div class="description">
					<h5><i>Description</i></h5>
					<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore 
						eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident.
						Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut 
						odit aut fugit, sed quia consequuntur magni dolores eos qui 
						ratione voluptatem sequi nesciunt.</p>
				</div>
			
				
				<div class="simpleCart_shelfItem">
					<p><i class="item_price">₹{product.price}</i></p>
					
						  
						<button onClick={()=>addCartApi(product)} type="submit" class="w3ls-cart">Add to cart</button>
				
				</div> 
			</div>
           
                </div>
                </div>
    )
}