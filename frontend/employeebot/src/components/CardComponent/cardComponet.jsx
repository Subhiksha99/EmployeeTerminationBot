import './cardComponent.css'
const CardComponent = (props) => {
    return ( 
        <>
            <div className="card mx-5" style={{ backgroundColor: "#8C9AC8" }}>
                <div className="card-body">
                    <h5 className="card-title cardTitle ">{props.title}</h5>
                    <p className="card-text cardContent ">{props.textContent}</p>
                </div>
            </div>
        </>
     );
}
 
export default CardComponent;