import { useState, useEffect } from 'react';
import './profileComponent.css'
import profile from "../../assets/profileIcon.jpeg"

const ProfileComponent = () => {

    const [user, setUser] = useState([]);

    useEffect(() => {
        // setUser({ "name": "Kollu Siva Sai", "email": "sivasai@gmail.com", "contactNo": 9897348453, "designation": "HR" })
        console.log(localStorage.getItem("user-detail"));
        let u = localStorage.getItem("user-detail");
        console.log(u.email);
        setUser(u);
    }, [])

    return (
        <>
            <div className="container-fluid text-center pb-1" style={{ backgroundColor: "#C4C4C4" }}>
                <div className="profile">
                    <img src={profile} className="img-fluid mt-4 profile-image" alt="profile.jpeg" />
                    <div className="details mx-auto p-3 my-3" style={{ backgroundColor: "#8C9AC8" }}>
                        <table className="w-50 mt-3 mb-2 p-3 mx-auto details-table">
                            <tbody>
                                <tr>
                                    <th className="details-th">Name</th>
                                    <th className="details-th">:</th>
                                    <td className="details-td">Subhiksha</td>
                                </tr>
                                <tr>
                                    <th className="details-th">Email</th>
                                    <th className="details-th">:</th>
                                    <td className="details-td">subhiksha425@gmail.com</td>
                                </tr>
                                <tr>
                                    <th className="details-th">Contact No</th>
                                    <th className="details-th">:</th>
                                    <td className="details-td">9150915516</td>
                                </tr>
                                <tr>
                                    <th className="details-th">Designation</th>
                                    <th className="details-th">:</th>
                                    <td className="details-td">HR</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                </div>
            </div>
        </>
    );
}

export default ProfileComponent;