import * as React from "react";

const Product = ({productData}) => {

    return (
        <div className={"productData"}>
            <img className={"productImage"} src={productData.pictureUrl}/>
            <div className={"productWrapper"}>
                <div className={"productName"}>
                    {productData.name}
                </div>
                <div className={"productRow productDobleColumn"}>
                    <div>
                        <label className={"ratingLabel"}>rating</label>
                        <div className={"rating"}>{productData.rating}</div>
                    </div>
                    <div>
                        <label className={"priceLabel productTextRight"}>price</label>
                        <div className={"price productTextRight"}>{productData.price}</div>
                    </div>
                </div>
                <div className={"productRow"}>
                    <div className={"productDescription"}>{productData.description}</div>
                </div>
                <div className={"productTextRight"}>
                    Best price was:
                </div>
                <div className={"productRow productDobleColumn"}>
                    <div className={"bestPrice"}>{productData.historicalBestPrice}</div>
                    <div className={"bestPriceDate productTextRight"}>
                        {productData.bestPriceDate}</div>
                </div>
                <div className={"productRow productDobleColumn"}>
                    <div>
                        <label className={"ratingLabel"}>produced by</label>
                    </div>
                    <div>
                        <div className={"productTextRight"}>{productData.producerName}</div>
                    </div>
                </div>
                <div className={"productRow"}>
                    <button  className={"productBuyButton"}>
                        Buy
                    </button>
                </div>
            </div>
        </div>
    );
};

export default Product;